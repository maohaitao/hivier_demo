package com.bike.logserver.rest;
import com.bike.bananacard.common.constant.AppContext;
import com.bike.bananacard.common.emu.PaltmType;
import com.bike.bananacard.common.tools.json.JsonResult;
import com.bike.logserver.interceptor.request.RequestParameterContext;
import com.bike.logserver.interceptor.request.RequestParameterContextBuilder;
import com.sf.common.log.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/{p}/{v}")
public class LogController {

    @RequestMapping(value = "/logServer", method = {RequestMethod.POST,RequestMethod.GET}, produces = AppContext.PRODUCES)
    @ResponseBody
    public String logServer(@PathVariable("p") String p, @PathVariable("v") String v) throws Exception {
        JsonResult jsonResult = new JsonResult();
        RequestParameterContext requestParameterContext = RequestParameterContextBuilder.get();
        String code = requestParameterContext.getAsString("code");
        String data = requestParameterContext.getAsString("data");
//      AssertUtils.assertEmpty(startDate, "start_date");
//      AssertUtils.assertEmpty(endDate, "end_date");
//      System.out.println("test====code:"+code+"  ==code:"+data);
        PaltmType type = PaltmType.valueOf(p);
        String re = code+"||"+requestParameterContext.getHeader().string()+"||"+type.getType()+"||"+requestParameterContext.getAccountId()+"||"+data;
        LogService.info(re);
        return jsonResult.success();
    }

}
