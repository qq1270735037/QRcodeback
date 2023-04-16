package com.code.qrcodeback.utils.result.code;

public interface Code {
	// 成功
	int SUCCESS  = Errs.put(200, "成功");
	// 操作有误
	int ERROR	 = Errs.put(-1, "操作有误");
	// 未知错误
	int LOGIN_OUT	 = Errs.put(-2, "登录失效");
	// 账号或密码错误
	int LOGIN_NOT_EXIST	 = Errs.put(-3, "账号或密码错误");
	//登录成功
	int LOGIN_SUCCESS  = Errs.put(201, "登录成功");
}
