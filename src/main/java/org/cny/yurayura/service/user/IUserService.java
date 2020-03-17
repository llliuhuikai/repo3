package org.cny.yurayura.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.cny.yurayura.entity.user.User;

/**
 * 用户 service
 *
 * @author CNY
 * @since 2019-10-27
 */
public interface IUserService extends IService<User> {

    /**
     * 分页查询用户（B端）
     *
     * @param pageNum
     * @return com.github.pagehelper.PageInfo<java.lang.Object>
     */
    public PageInfo<Object> getPageToB(Integer pageNum);

}
