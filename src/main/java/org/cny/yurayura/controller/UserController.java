package org.cny.yurayura.controller;


import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.cny.yurayura.entity.User;
import org.cny.yurayura.service.IUserService;
import org.cny.yurayura.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 controller
 * </p>
 *
 * @author CNY
 * @since 2019-10-27
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 分页查询全部用户（剔除了隐私字段）
     *
     * @param pageNum
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/getPageToNoPvt")
    @ApiOperation("分页查询全部用户（剔除了隐私字段）")
    @ApiImplicitParam(name = "pageNum", value = "当前页数", defaultValue = "1", required = true)
    public ApiResult getPageToNoPvt(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum) {
        if (pageNum == 0) {
            return ApiResult.warn("请输入页数");
        }
        PageInfo<User> userPageInfo = iUserService.getPageToNoPvt(pageNum);
        if (userPageInfo.getTotal() != 0) {
            return ApiResult.success("分页查询成功", userPageInfo);
        } else {
            return ApiResult.warn("系统数据为空");
        }
    }

}

