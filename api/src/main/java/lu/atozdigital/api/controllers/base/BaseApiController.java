package lu.atozdigital.api.controllers.base;

import jakarta.servlet.http.HttpServletRequest;

public class BaseApiController {

    protected Integer extractAccountId(HttpServletRequest request){
        return (Integer) request.getAttribute("account_id");
    }

}
