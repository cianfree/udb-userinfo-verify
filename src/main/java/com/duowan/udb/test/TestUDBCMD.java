package com.duowan.udb.test;

import com.duowan.userinfo.IUserDetailUdbThrift;
import com.duowan.userinfo.domain.UdbUserInfo;
import com.duowan.userinfo.impl.ThriftClientFactory;

/**
 * 测试UDB是否工作正常
 *
 * @author Arvin
 * @time 2017/3/16 16:21
 */
public class TestUDBCMD {

    public static void main(String[] args) {

        Param param = new Param(args);

        if (param.isHelp()) {
            Param.showHelp();
            return;
        }


        IUserDetailUdbThrift client = ThriftClientFactory.getUdbClient(param.getHost(), param.getPort(), 5000);
        UdbUserInfo userInfo1 = client.byYyuid(param.getYyuid());
        UdbUserInfo userInfo2 = client.byPassport(param.getPassport());

        System.out.println("****************************************************************************");
        System.out.println("\t>> 测试参数：");
        System.out.println("\tSA主机：      " + param.getHost());
        System.out.println("\tSA端口：      " + param.getPort());
        System.out.println("\t测试YYUID：   " + param.getYyuid());
        System.out.println("\t测试Passport：" + param.getPassport());

        System.out.println("****************************************************************************");
        System.out.println("\t>> 使用YYUID调用返回用户信息结果：");
        showUserInfo(userInfo1);

        System.out.println("\n\t>> 使用Passport调用返回用户信息结果：");
        showUserInfo(userInfo2);

        System.out.println("****************************************************************************");
    }

    private static void showUserInfo(UdbUserInfo userInfo) {
        if (userInfo != null) {
            System.out.println("\tAccount:    " + userInfo.getAccount());
            System.out.println("\tMobile:     " + userInfo.getMobile());
            System.out.println("\tPassport:   " + userInfo.getPassport());
            System.out.println("\tImid:       " + userInfo.getImid());
            System.out.println("\tUdbSeq:     " + userInfo.getUdbSeq());
            System.out.println("\tyyUid:      " + userInfo.getYyUid());
        } else {
            System.out.println("返回用户信息结果为空!");
        }
    }

}
