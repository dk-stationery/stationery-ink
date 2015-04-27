package org.tommy.stationery.ink.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kun7788 on 15. 4. 27..
 */
@Controller
public class JspController {

    @RequestMapping("/_hcheck.hdn")
    public @ResponseBody String welcome() {
        return "<html>\n" +
                "<head></head>\n" +
                "<body>HealthCheck OK</body>\n" +
                "</html>";
    }
}
