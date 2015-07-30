package org.tommy.stationery.ink.daemon.controller.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tommy.stationery.ink.daemon.config.ParametersConfig;
import org.tommy.stationery.ink.daemon.service.metastore.AuthService;
import org.tommy.stationery.ink.domain.meta.Auth;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.exception.InkException;

/**
 * Created by kun7788 on 15. 6. 18..
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    ParametersConfig parametersConfig;

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public Object check(@RequestParam(value = "user", required = true) String user, @RequestParam(value = "password", required = true) String password) throws Exception {
        String isEnableAuth = ParametersConfig.StringValue(parametersConfig.getConfig().get("auth").get("enable"));
        if ("false".equals(isEnableAuth)) {
            return "succeed";
        }

        Auth auth = authService.getInkAuth(new Auth(user, password));
        if (auth == null) {
            throw new InkException(MessageEnum.INVALID_AUTH_INFO);
        }

        return "succeed";
    }
}
