package cn.zkw.realm;

import javax.annotation.Resource;

import cn.zkw.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

//import cn.zkw.service.back.IMemberServiceBack;
import cn.zkw.vo.User;
import cn.zkw.util.encrypt.MyPasswordEncrypt;

public class MemberRealm extends AuthorizingRealm {
	private Logger log = Logger.getLogger(MemberRealm.class);
	@Resource
	private UserService service;

	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		log.info("********** 2、用户角色与权限：doGetAuthorizationInfo **********");
//		String username = (String) principals.getPrimaryPrincipal() ;	// 取得用户登录名
//		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo() ;	// 定义授权信息的返回数据
//		try {
//			Map<String,Object> map = this.service.listAuthByMember(username) ;
//			Set<String> allRoles = (Set<String>) map.get("allRoles") ;
//			Set<String> allActions = (Set<String>) map.get("allActions") ;
//			auth.setRoles(allRoles);// 所有的角色必须以Set集合的形式出现
//			auth.setStringPermissions(allActions); 	// 所有的权限必须以Set集合的形式出现
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return auth;
        return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.info("********** 1、用户登录认证：doGetAuthenticationInfo() **********");
		// 1、登录认证的方法需要先执行，需要用他来判断登录的用户信息是否合法
		String username = (String) token.getPrincipal(); // 取得用户名
		System.out.println(username);
		// 需要通过用户名取得用户的完整信息，利用业务层操作
		User vo =  this.service.getUserByName(username);	// 根据后台业务查询用户的完整数据
		if (vo == null) {
			throw new UnknownAccountException("该用户名称不存在！");
		} else if (vo.getUser_lock() == null || vo.getUser_lock().equals(1)) {
//			throw new UnknownAccountException("该用户已经被锁定了！");
			throw new LockedAccountException("账户已经被锁定");
		} else { // 进行密码的验证处理
			String password = MyPasswordEncrypt.encryptPassword(new String((char[]) token.getCredentials()));
			// 将数据库中的密码与输入的密码进行比较，这样就可以确定当前用户是否可以正常登录
			System.out.println(vo.getUser_password().equals(password));
			if (vo.getUser_password().equals(password)) { // 密码正确
				AuthenticationInfo auth = new SimpleAuthenticationInfo(username, password, "memberRealm");
				SecurityUtils.getSubject().getSession().setAttribute("name", vo.getUser_nickname());
				SecurityUtils.getSubject().getSession().setAttribute("photo",vo.getUser_photo());
				return auth;
			} else {
				throw new IncorrectCredentialsException("密码错误！");
			}
		}
	}
}
