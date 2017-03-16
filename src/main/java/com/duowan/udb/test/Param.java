package com.duowan.udb.test;

/**
 * 输入参数
 *
 * @author Arvin
 * @time 2017/3/16 16:44
 */
public class Param {

    /** -h 选项 必填 YYServiceAgent 地址, 域名或 IP */
    private String host;

    /** -p 选项 可选，默认是12300 YYServiceAgent 端口 */
    private int port = 12300;

    /** -y 选项 可选， yyuid参数， 默认是 506280127 */
    private long yyuid = 506280127;

    /** -P 选项 可选， passport参数， 默认是 aa769429560 */
    private String passport = "aa769429560";

    /** --help 选项 帮助选项 */
    private boolean help = false;

    public Param(String[] args) {
        if (args == null || args.length < 1) {
            throw new IllegalArgumentException("参数不正确，请至少输入-h选项！");
        }
        for (String arg : args) {
            if (arg.startsWith("-h")) {
                host = arg.substring(2);
            }
            if (arg.startsWith("-P")) {
                passport = arg.substring(2);
            }
            if (arg.startsWith("-p")) {
                this.port = Integer.parseInt(arg.substring(2));
            }
            if (arg.startsWith("-y")) {
                this.yyuid = Long.parseLong(arg.substring(2));
            }
            if (arg.startsWith("--help")) {
                this.help = true;
            }
        }

        if (!isHelp()) {
            // 检测参数
            if (this.host == null || this.host.trim().equals("")) {
                System.out.println("参数不正确，请提供Host！");
                showHelp();
            }
        }
    }

    /**
     * 显示帮助信息
     */
    public static void showHelp() {
        System.out.println("****************************************************************************");
        System.out.println("\t-h\t必填 YYServiceAgent 地址, 域名或 IP");
        System.out.println("\t-p\t可选，默认是12300 YYServiceAgent 端口");
        System.out.println("\t-y\t可选，yyuid参数， 默认是 506280127");
        System.out.println("\t-P\t可选，passport参数， 默认是 aa769429560");
        System.out.println("\t-help\t可选，帮助选项");
        System.out.println("****************************************************************************");
    }

    public static void main(String[] args) {
        Param param = new Param(new String[]{"-hlocalhost"});
        System.out.println(param.getHost());
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public long getYyuid() {
        return yyuid;
    }

    public String getPassport() {
        return passport;
    }

    public boolean isHelp() {
        return help;
    }
}
