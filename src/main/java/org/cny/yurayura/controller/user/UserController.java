package org.cny.yurayura.controller.user;


import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.cny.yurayura.dto.UserSelectDTO;
import org.cny.yurayura.service.user.IUserService;
import org.cny.yurayura.vo.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 controller
 *
 * @author CNY
 * @since 2019-10-27
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户API")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 查询用户（根据id）
     *
     * @param id
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/getById")
    @ApiOperation("查询用户（根据id）")
    @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "1", dataType = "int")
    public ApiResult getById(Integer id) {
        if (StringUtils.isEmpty(id)) {
            return ApiResult.warn("id不能为空");
        }
        return ApiResult.success("查询成功", iUserService.getById(id));
    }

    /**
     * 分页查询用户（B端）
     *
     * @param pageNum
	 * @param dto
     * @return org.cny.yurayura.vo.ApiResult
     */
    @PostMapping("/getPageToB")
    @ApiOperation("分页查询用户（B端）")
    @ApiImplicitParam(name = "pageNum", value = "当前页数", defaultValue = "1", required = true, dataType = "int")
    public ApiResult getPageToB(Integer pageNum, UserSelectDTO dto) {
        if (StringUtils.isEmpty(pageNum)) {
            return ApiResult.warn("页数不能为空");
        }
       return iUserService.getPageToB(pageNum, dto);
    }

}

