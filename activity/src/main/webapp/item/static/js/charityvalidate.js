/** 
 * 根据easyvalidate的改造而来
 */
(function($) {


	   
	$.fn.bikeValidate = function(settings){
	
		// 默认值
		var config = {
			promptPosition : 'topRight',
			promptPositionOffset : 30, // 如果 promptPosition = topRight，此参数调整自右边起偏移的距离，如果是 topLeft 即从左边起偏移的距离
      notCheckHidden : true,
			validateOnDialog : false,    //是否是在dialoag中进行校验
			noCheckAction: '/www/image/uploadImg'         //对某一个action不进行校验，主要用于图片上传			
		};
		
		   
		var settings = $.extend(config, settings);
			
		var validateWidget=new ValidateWidget($(this), settings);
		validateWidget.init();
			
		return validateWidget;

		
	};		
	
	function ValidateWidget(validateDiv, settings) {
	    this.validateDiv=validateDiv;
		this.settings=settings;
	};
	
	
	ValidateWidget.prototype.init=function() {
				// GET ALL FORM ELEMENTS
		this.elements = this.validateDiv.find('input, textarea, radio, checkbox, select');
		
	   
		//存放提示div的数组
		this.promptArray = new Array();
		
		  //存放第一个没有通过校验的元素(html元素)
		this.firstInvalidElement=null;
		
		this.form = this.validateDiv.find("form");	
			
		var that = this;
		$(this.form).submit(function() {
		    
			var action = $.trim(that.form.attr("action"));
			if (action!=that.settings.noCheckAction) {
			    if ( that.check()==false) {
		    	    return false;
		        };
			}
		    
		});
		
		// FOCUS LISTERNER
		var that=this;
		this.elements.each(function(){
			$(this).blur(function(){
				that.getRules( $(this) );				  
			});									   
		});
		
		var that=this;
		$(window).resize(function(){
		    that.refreshAllPrompt();
		});
	
	};
	
	
	
	/**
	 * 检查校验是否通过，通过则返回true,否则则返回false
	 */
	ValidateWidget.prototype.check = function(){
		
	
		if (this.settings.tabWidget) {
	            //存放没有通过校验的tab页的下标，从0开始
	        this.invalidTabNoArray=new Array();
	    }
	       //存放promptdiv的数组
		this.promptArray = new Array();
	    
	    this.formValid = true;
	    this.firstInvalidElement=null;   //只有提交时，才使用第一个没有通过校验的按钮得到焦点这一效果
	    
	    var that =this;
	    
	    
		this.elements.each(function(){
		    
			var elementTagName = this.tagName.toLowerCase();
			
			var elementType = $(this).attr('type');
			if( elementTagName == 'input' &&( elementType == 'text'|| elementType == 'password') || elementTagName == 'textarea' || elementTagName == 'select' ){
				that.getRules( $(this) );
			}
		});
		
		
				
		    
		if ( this.settings.tabWidget && this.invalidTabNoArray ) {

		    if ( this.invalidTabNoArray.length>0 ) {						
				    //如果当前tab页没有通过校验，则不切换tab页，否则切换到第一个没有通过校验的tab页
			    if ( $.inArray(this.settings.tabWidget.currentTabNo, this.invalidTabNoArray) == -1 ) {
				    this.settings.tabWidget.showTabByIndex( (this.invalidTabNoArray)[0] );
				}
				
				
			}     
		}
		
		
		if ( this.firstInvalidElement!=null ) {
		    $(this.firstInvalidElement).focus(); 
			this.firstInvalidElement=null;
		}
		
		if( this.formValid==false ){
			return false;
		}else {
			return true;
		}
		
	};
		
		
	
	
	ValidateWidget.prototype.getRules=function(element) {
		
		   //如果有tab控件，则强制校验
		if ( this.settings.notCheckHidden==true && typeof(this.settings.tabWidget)=="undefined") {
	            
			    //隐藏的字段则不进行校验
		    if ($(element).is(":hidden")) {
		        return true;
		    }
		}
		
		var elementValid = true;
		var rulesParsed = element.attr('class');
		
		if(rulesParsed){
			var rules = rulesParsed.split(' ');
			elementValid = this.validate(element, rules);
			
			    //记录第一个没有通过校验的元素(html元素)
			if ( elementValid==false && this.firstInvalidElement==null ) {
		        this.firstInvalidElement = element;
			}
		}	
    
    return elementValid;	    
	};
	
	/** 对元素进行校验，成功则返回true,失败则返回false **/
	ValidateWidget.prototype.validate=function(element, rules){


		    var elementValid=true;
			
		    // LOOP RULES FOR EACH ELEMENT
			var promptText="";
			   //去除空格
			var elementVal = $.trim(element.val());
			
			for(var i=0; i<rules.length; i++){

				if ( rules[i] == 'c_required' ){
				    promptText=promptText+checkObject.required(elementVal);
				}
				
				if (elementVal) {
				    switch(rules[i]){
			        case 'c_positivenum':
				    	promptText=promptText+checkObject.positivenum(elementVal);	
				    	continue;					
				    case 'c_num':
				    	promptText=promptText+checkObject.num(elementVal);	
				    	continue;
				    case 'c_email':
				    	promptText=promptText+checkObject.email(elementVal);	
				    	continue;
				    	
				    case 'c_positive':
				        promptText=promptText+checkObject.positive(elementVal);
				    	continue;
				    case 'c_chinese':
				    	promptText=promptText+checkObject.chinese(elementVal);
				    	continue;
				    case 'c_zipcode':
				    	promptText=promptText+checkObject.zipcode(elementVal);
				    	continue;
				    case 'c_tel':
				    	promptText=promptText+checkObject.tel(elementVal);
				    	continue;
				    case 'c_fax':
				    	promptText=promptText+checkObject.fax(elementVal);
				    	continue;
				    case 'c_mobile':
				    	promptText=promptText+checkObject.mobile(elementVal);
				    	continue;
				    case 'c_linephone':
				    	promptText=promptText+checkObject.linephone(elementVal);
				    	continue;
				    case 'c_date':
				    	promptText=promptText+checkObject.date(elementVal);
				    	continue;
				    case 'c_gtdate':
				    	promptText=promptText+checkObject.gtdate(elementVal);
				    	continue;
				    case 'c_ltdate':
				    	promptText=promptText+checkObject.ltdate(elementVal);
				    	continue;
					case 'c_datemonth':
				    	promptText=promptText+checkObject.datemonth(elementVal);
				    	continue;					    
					case 'c_strictIdCard':
				    	promptText=promptText+checkObject.strictIdCard(elementVal);
				    	continue;	
					case 'c_unstrictIdCard':
						promptText=promptText+checkObject.unstrictIdCard(elementVal);
				    	continue;
					case 'c_english':
						promptText=promptText+checkObject.english(elementVal);
						continue;
					case 'c_url':
						promptText=promptText+checkObject.url(elementVal);
						continue;
					case 'c_ltrim':
						promptText=promptText+checkObject.url(elementVal);
						continue;
					case 'c_age':
						promptText=promptText+checkObject.age(elementVal);
						continue;	
                    case 'c_username':	
	                    promptText=promptText+checkObject.username(elementVal);
						continue;						
				    }
					
				    if (rules[i].substr(0,12) == 'c_minlength_') {
				        promptText=promptText+checkObject.minlength(elementVal, rules[i].substr(12));
				    	}
				    if( rules[i].substr(0,12) == 'c_maxlength_'){
				    	promptText=promptText+checkObject.maxlength(elementVal, rules[i].substr(12));
				    }
				    if( rules[i].substr(0,9) == 'c_maxnum_'){
				    	promptText=promptText+checkObject.maxnum(elementVal,rules[i].substr(9));
				    }
				    if( rules[i].substr(0,9) == 'c_minnum_'){
				    	promptText=promptText+checkObject.minnum(elementVal,rules[i].substr(9));
				    }
				}
				
				
			}
	
	        
	        if (promptText != "") {
                elementValid=false;
			    this.formValid=false;
			}
			
			// BUILD PROMPT IF RULE FAILS
			if(elementValid){
				this.removePrompt(element);	
			} else {
                this.buildPrompt(element, promptText);		
			}
			
			return elementValid;
	};
	
	
	/**
	 *手工增加提示
	 *elementId为不带#的
	 */
	ValidateWidget.prototype.addPrompt = function(elementId, promptText) {
	    var element =   document.getElementById(elementId);
        this.buildPrompt(element, promptText+" <br />");
        $(element).focus();		
	}
	
	ValidateWidget.prototype.addPromptWithoutFocus = function(elementId, promptText) {
    var element = document.getElementById(elementId);
    this.buildPrompt(element, promptText+" <br />");
	}
	
    //构建提示层
	ValidateWidget.prototype.buildPrompt=function(element, promptText) {
		    
			if ( this.settings.tabWidget && this.invalidTabNoArray  ) {
			        //把没有通过校验的tab页的下标记录在invalidTabNoArray中
				var tabNoOfElement = this.settings.tabWidget.findTabIndexOfElement( $(element).attr("id") );
				
				var isTabNoIn = $.inArray(tabNoOfElement, this.invalidTabNoArray);
				
				if (isTabNoIn==-1) {
				    this.invalidTabNoArray.push(tabNoOfElement);
				}
				
				if ( $(element).is(":hidden") ) {
				        //如果是隐藏元素，则不构造提示浮层
					return;
				}
								 
			}
			    
			// REMOVE ALL EXISTING PROMPTS ON INIT
			this.removePrompt(element);
			   
			this.createAndShowPrompt(element, promptText);
			
			
	};
	    //创建并显示element所对应的提示,并且保存到this.promptArray中
	ValidateWidget.prototype.createAndShowPrompt=function(element, promptText){
	
			   //创建错误提示
			var divFormError = $('<div></div>');
			$(divFormError).addClass('formError');
			$(divFormError).addClass( 'formError'+$(element).attr('name').replace('.','') );	
            $(divFormError).attr("elementid",$(element).attr('id'));		

		    if ( this.settings.validateOnDialog ) {
			    $('body').append(divFormError);
			}else {
			    $(element).parent().append(divFormError);
            }			
			//存放到promptArray中
            this.promptArray.push(divFormError);
			
			// CREATE ERROR CONTENT
			var formErrorContent = $('<div></div>');
			$(formErrorContent).addClass('formErrorContent');
			$(divFormError).append(formErrorContent);
			$(formErrorContent).html(promptText);
			
			// CREATE ERROR ARROW
			var formErrorArrow = $('<div></div>');
			$(formErrorArrow).html('<div class="line10"><!-- --></div><div class="line9"><!-- --></div><div class="line8"><!-- --></div><div class="line7"><!-- --></div><div class="line6"><!-- --></div><div class="line5"><!-- --></div><div class="line4"><!-- --></div><div class="line3"><!-- --></div><div class="line2"><!-- --></div><div class="line1"><!-- --></div>');
			$(formErrorArrow).addClass('formErrorArrow');
			$(divFormError).append(formErrorArrow);
			
            
			var position=this.getPromptPosition($(element), divFormError);
 			
            this.showPrompt(divFormError, position.top, position.left);	

            		
	}
	
	/*
	 *计算元素所对应的提示的位置(top和left值),返回一个对象object, object.left表示left; object.top表示top
	 *
	 */
	ValidateWidget.prototype.getPromptPosition=function(element, promtDiv) {
		    
			// 得到每个元素的宽度，高度，以及绝对位置
		var fieldWidth = element.width();
		var fieldHeight = element.height();
		var fieldTopPosition = element.offset().top;
		var fieldLeftPosition = element.offset().left;
		
		    // 计算绝对位置
		if( this.settings.promptPosition == 'topRight'){
			fieldTopPosition = fieldTopPosition - promtDiv.height();
			fieldLeftPosition = fieldLeftPosition + fieldWidth - this.settings.promptPositionOffset;
		}
		if( this.settings.promptPosition == 'topLeft'){
			fieldTopPosition = fieldTopPosition - promtDiv.height();
			fieldLeftPosition = fieldLeftPosition + this.settings.promptPositionOffset;
		}	

		return {top:fieldTopPosition,left:fieldLeftPosition};
	}
	
	/*
	 *刷新所有提示，主要应对某个div的位置发生变化后，提示也需要跟着移动的情况
	 */
	ValidateWidget.prototype.refreshAllPrompt=function() {
	    
		for(var i=0; i<this.promptArray.length; i++) {
		    var elementid = $( (this.promptArray)[i] ).attr("elementid");
            var element = $("#"+elementid);
                
			var promptDiv=(this.promptArray)[i];
			
		     //如果元素已经被隐藏了,则去除它的提示
            if ( element.is(":hidden") ) {
                $(promptDiv).remove();	
                continue;
            }
			
            var promptNewPosition = this.getPromptPosition(element, promptDiv);
			
            if ( promptNewPosition.top!= promptDiv.offset().top || promptNewPosition.left!= promptDiv.offset().left ) {
			    
			    this.showPrompt(promptDiv, promptNewPosition.top, promptNewPosition.left);	
			   
			}			
		}    
	};
	
	   //给定一个promptDiv，以及它的绝对位置，显示它
	ValidateWidget.prototype.showPrompt=function(promptDiv, promptDivTop, promptDivLeft) {
        $(promptDiv).css({
		    position : 'absolute',
		    top : promptDivTop,
		    left : promptDivLeft,
		    opacity : 0
		});
		
		 //显示prompt
		$(promptDiv).animate({
		    opacity : 0.8
		});		
	};
	
	ValidateWidget.prototype.removePrompt=function(element) {
	    if ( $(element).attr('name') ) {
	        $('body').find( '.formError'+$(element).attr('name').replace('.','') ).remove();
		}
	};
	
	ValidateWidget.prototype.formSubmit=function(){
			
		this.form.submit();
			
	};
	
	
	var checkObject={
	    required:function(elementVal){
			if( ! elementVal ){
				return '必填字段 <br />';
			}else {
			    return "";
			}
		},
		ltrim:function(elementVal){
			var newElementVal =elementVal.replace(/^\s*/,"");
			if(newElementVal.length!=elementVal.length){
				return '不能以空格开头 <br />';
			}else {
			    return "";
			}
		},
		minlength:function(elementVal, lenStr) {
		    var len = parseInt(lenStr);
		    if ( elementVal.length<len) {
				return '最小长度不得小于' + len+ " <br />";
			}else {
			    return "";
			}
		},
		
		maxlength:function(elementVal, lenStr) {
		    var len = parseInt(lenStr);
		    if (  elementVal.length>len) {
				return '最大长度不得大于' + len;
			}else {
			    return "";
			}
		},
		
		   //正整数的判断
		positive:function(elementVal) {
            var filter = /^\s*\d+\s*$/;
			if (  !filter.test( elementVal )) {
				return '只能是正整数 <br />';
			}else {
			    return "";
			}							    
		},
		
		   //数字的判断(整数，浮点数，包括负数的判断)
		num:function(elementVal) {
			 var filter = /^\s*(-?\d+)(\.\d{0,2})?\s*$/;
				if (  !filter.test( elementVal )) {
					return '请输入整数、浮点数（保留小数点后两位   包括负数）<br />';
				}else {
					return "";
				}
				
		},
		
				   //数字的判断(整数，浮点数的判断，包括0)
		positivenum:function(elementVal) {
			 var filter = /^\s*(\d+)(\.\d{0,2})?\s*$/;
				if (  !filter.test( elementVal )) {
					return '请输入整数或者小数点保留后两位<br />';
				}else {
					return "";
				}
				
		},
		 
		    //数字最大值的判断
		maxnum:function(elementVal,numstr) {
			var num = parseInt(numstr);
			   if( elementVal > num){
						return '数字最大值不得大于' + num+ " <br />";
					}else{
						return "";
					}
		},
		
		   //数字最小值的判断
		minnum:function(elementVal, numstr) {
			var num = parseInt(numstr);
			if( elementVal < num){
						return '数字最小值不得小于' +num+ " <br />";
					}else{
						return "";
					}
		},
		
		chinese:function(elementVal) {
		    var filter = /^[\u4E00-\u9FA5]+$/;
			if (  !filter.test( elementVal )) {
				return '只能输入中文 <br />';
			}else {
			    return "";
			}	
		},
					
		
		// RULE: VALID EMAIL STRING REQUIRED
		email:function(elementVal){
			var filter = /^\s*([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+\s*$/;
			if (  !filter.test( elementVal )) {
				return '请输入正确的邮件地址';
			}else {
			    return "";
			}	
		},
		
		zipcode:function(elementVal) {
		    var filter = /^\s*[0-9]{6}\s*$/;
			if ( !filter.test(elementVal )) {
			    return '请输入正确的邮编 <br />';
			}else {
			    return "";
			}	
		},
		
		   //手机和固定电话的判断
		tel:function(elementVal) {
		    var filter = /^\s*(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})){1}\d{8})|(^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{2,5}))?$)\s*$/;
		    	//^\s*(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})){1}\d{8})|((([0\+]\d{2,3}[-—])?(\d{2,3})[-—])?(\d{7,8})([-—](\d{3,}))?)\s*$
			if (  !filter.test(elementVal )) {
			    return '请输入正确的电话号码 <br />';
			}else {
			    return "";
			}					
		},
		   //传真的判断
		fax:function(elementVal) {
		    var filter = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
		    if (  !filter.test(elementVal )) {
			    return '请输入正确的传真号码 <br />';
			}else {
			    return "";
			}					

		},
		
					   //手机电话的判断
		mobile:function(elementVal) {
		    var filter = /^\s*(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})){1}\d{8})\s*$/;

			if (  !filter.test(elementVal )) {
			    return '请输入正确的手机号码 <br />';
			}else {
			    return "";
			}					

		},
		    //固定电话的判断
		linephone:function(elementVal) {
			var filter = /^\s*((([0\+]\d{2,3}[-—])?(0\d{2,3})[-—])?(\d{7,8})([-—](\d{2,5}))?)\s*$/;

			if (  !filter.test(elementVal )) {
			    return '请输入正确的固定电话号码 <br />';
			}else {
			    return "";
			}	
		},
		
		date:function(elementVal) {
			var filter = /^\s*(([1-9][0-9]{3})[-]((0?[1-9])|1[0-2])[-]((0?[1-9])|[1-2][0-9]|3[0-1]))\s*$/;
			
			if (  !filter.test(elementVal )) {
			    return '请输入正确的日期 <br />';
			}else {
			    return "";
			}	
		},
		gtdate:function(elementVal) {
			if(Date.parse(elementVal) - Date.parse(new Date())>0) {
			    return '开始日期大于现实日期，请输入正确的日期 <br />';
			}else {
			    return "";
			}	
		},
		ltdate:function(elementVal) {
			if(Date.parse(elementVal) - Date.parse(new Date())<0) {
			    return '开始日期小于现实日期，请输入正确的日期 <br />';
			}else {
			    return "";
			}	
		},
		
		    //日期的判断，可以只填写到月，也可以填写到天
		datemonth:function(elementVal) {
			var filter = /^\s*(([1-9][0-9]{3})[-]((0?[1-9])|1[0-2])([-]((0?[1-9])|[1-2][0-9]|3[0-1]))?)\s*$/;
			
			if (  !filter.test(elementVal )) {
			    return '请输入正确的日期，yyyy-mm或者yyyy-mm-dd <br />';
			}else {
			    return "";
			}			 
		},
		
		unstrictIdCard:function(elementVal){
			var filter = /^\s*((\d{15})|(\d{17}(\d|[Xx])))\s*$/;
			
			if (  !filter.test(elementVal )) {
			    return '请输入正确的身份证号码 <br />';
			}else {
			    return "";
			}	
			
		},
		english:function(elementVal){
			var filter = /^((\s*[a-zA-Z]+\s*[-_/\&'——’—]*\s*)*[a-zA-Z]*\s*)$/;
				
			if (  !filter.test(elementVal )) {
			    return '只能输入英文 <br />';
			}else {
			    return "";
			}
			
		},
		url:function(elementVal){
			var filter =/^\s*(http?:\/\/)?(w{3}\.)?(\w\.?\-?\w+)+(\.\w+)+(:\d+)?(\/?[\w- .\/\|#?%&=]*)\s*$/
			if (  !filter.test(elementVal )) {
			    return '请输入正确的网址 <br />';
			}else {
			    return "";
			}
		},
		age:function(elementVal){
            var filter = /^\s*(([0-9])|([1-9][0-9])|(1([0-9]{2})))\s*$/
			if (  !filter.test( elementVal )) {
				return '请输出正确的年龄0-199 <br />';
			}else {
			    return "";
			}	
		},
		username:function(elementVal){
            var filter = /^[0-9a-zA-Z\u4e00-\u9fa5]*$/
			if (  !filter.test( elementVal )) {
				return '请输入正确的用户名 <br />';
			}else {
			    return "";
			}	
		},
		   //严格的身份证校验,不仅仅校验位数，而且校验身份证的内在数字算法
		strictIdCard:function(elementVal) {
		    
			var idcard=elementVal;
			
			var result={
			    lenError:"身份证号码位数不对 <br />",
				birthdayError:"身份证号码出生日期超出范围或含有非法字符 <br />",
				checkError:"身份证号码校验错误 <br />",
				areaError:"身份证地区非法 <br />",
				right:""
			};
			 	
            var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"} 
            
            var idcard,Y,JYM;
            var S,M;
            var idcard_array = idcard.split("");
			
            /*地区检验*/
            if(area[parseInt(idcard.substr(0,2))]==null) 
            {
               return result.areaError; 
            }
			
            /*身份号码位数及格式检验*/
            switch(idcard.length){
                case 15:
                    if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){
                        ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性
                    } else {
                        ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性
                    }
                    
				    if(ereg.test(idcard)){
                        return result.right;    
                    }
                    else {
                        return result.birthdayError;
                    }
				    
                    break;
                
                case 18:
                    //18位身份号码检测
                    //出生日期的合法性检查 
                    //闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
                    //平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
                    if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
                        ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式
                    } else {
                        ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式
                    }
                    if(ereg.test(idcard)){//测试出生日期的合法性
                         //计算校验位
                         S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7 +
                             (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9 +
                             (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10  +
                             (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5   +
                             (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8   +
                             (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4   +
                             (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2   +
                             parseInt(idcard_array[7]) * 1 +
                             parseInt(idcard_array[8]) * 6 +
                             parseInt(idcard_array[9]) * 3 ;
							 
                         Y = S % 11;
                         M = "F";
                         JYM = "10X98765432";
                         M = JYM.substr(Y,1);/*判断校验位*/
                         
						 if(M == idcard_array[17]){
                             return result.right;
                         }
                         else {
                             return result.checkError;
                         }
                    }
                    else {
                        return result.birthdayError;                    
                    }
                    break;
                
                default:
                    return result.lenError;              
            }		    
		}
		
		
	};
		  

			
})(jQuery);
