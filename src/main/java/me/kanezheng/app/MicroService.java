package me.kanezheng.app;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MicroService {

    @NotNull(message = "参数msName不能为空")
    @Size(min=2, max = 20, message="微服务名字长度不应小于2字符，同时不应大于20字符")
    private String msName;

    @NotNull(message = "参数msTeam不能为空")
    @Size(min=2, max = 20, message="微服务所属团队长度不应小于2字符，同时不应大于20字符")
    private String msTeam;

    @NotNull(message = "参数msMaintainer不能为空")
    @Size(min=2, max = 20, message="微服务维护者名字长度不应小于2字符，同时不应大于20字符")
    private String msMaintainer;

    @NotNull(message = "参数msDesc不能为空")
    @Size(min=2, max = 255, message="微服务描述信息长度不应小于2字符，同时不应大于255字符")
    private String msDesc;

    @NotNull(message = "参数codeLang不能为空")
    @Size(min=1, max = 20, message="微服务编程语言不应小于2字符，同时不应大于20字符")
    private String codeLang;

    @NotNull (message = "参数bIsRestWS不能为空")
    @Min(value = 0, message = "bIsRestWS必须为0或1")
    @Max(value = 1, message = "bIsRestWS必须为0或1")
    private Boolean bIsRestWS;
    private Integer servicePort;

    public String getMsName() {
        return msName;
    }

    public void setMsName(String msName) {
        this.msName = msName;
    }

    public String getMsTeam() {
        return msTeam;
    }

    public void setMsTeam(String msTeam) {
        this.msTeam = msTeam;
    }

    public String getMsMaintainer() {
        return msMaintainer;
    }

    public void setMsMaintainer(String msMaintainer) {
        this.msMaintainer = msMaintainer;
    }

    public String getMsDesc() {
        return msDesc;
    }

    public void setMsDesc(String msDesc) {
        this.msDesc = msDesc;
    }

    public String getCodeLang() { return codeLang; }

    public void setCodeLang(String codeLang) { this.codeLang = codeLang; }

    public Boolean getbIsRestWS() { return bIsRestWS; }

    public void setbIsRestWS(Boolean bIsRestWS) { this.bIsRestWS = bIsRestWS; }

    public Integer getServicePort() { return servicePort; }

    public void setServicePort(Integer servicePort) { this.servicePort = servicePort; }

    @Override
    public String toString() {
        return "MicroService{" +
                "msName='" + msName + '\'' +
                ", msTeam='" + msTeam + '\'' +
                ", msMaintainer='" + msMaintainer + '\'' +
                ", msDesc='" + msDesc + '\'' +
                ", codeLang='" + codeLang + '\'' +
                ", bIsRestWS=" + bIsRestWS +
                ", servicePort=" + servicePort +
                '}';
    }
}
