
package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2301478600235967985L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("进入权限拦截器");
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		String name = (String) session.get("login");
		if (name == null||"".equals(name)) {
			ctx.put("tip", "请先登录!");
			return Action.LOGIN;
		}
			return invocation.invoke();
	}

}
