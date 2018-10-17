package com.lch.spring.boot.service;

import com.lch.spring.boot.model.ViewSpace;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/10/17 14:19
 **/
@Service(value = "viewSpaceService")
public class ViewSpaceService extends BaseService<ViewSpace> {
    @Override
    ViewSpace find() {
        ViewSpace viewSpace = new ViewSpace();
        viewSpace.setViewName("view");
        return viewSpace;
    }
}
