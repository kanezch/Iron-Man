package me.kanezheng.app.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description="All details about the microservice. ")
public class MicroService {

    @NotNull(message = "参数msName不能为空")
    @Size(min=2, max = 20, message="微服务名字长度不应小于2字符，同时不应大于20字符")
    @ApiModelProperty(notes = "The microservice's name")
    private String msName;

    @NotNull(message = "参数msTeam不能为空")
    @Size(min=2, max = 20, message="微服务所属团队长度不应小于2字符，同时不应大于20字符")
    @ApiModelProperty(notes = "The team this microservice belong to")
    private String msTeam;

    @NotNull(message = "参数msMaintainer不能为空")
    @Size(min=2, max = 20, message="微服务维护者名字长度不应小于2字符，同时不应大于20字符")
    @ApiModelProperty(notes = "The maintainer's name of this microservice")
    private String msMaintainer;

    @NotNull(message = "参数msDesc不能为空")
    @Size(min=2, max = 255, message="微服务描述信息长度不应小于2字符，同时不应大于255字符")
    @ApiModelProperty(notes = "The description of this microservice")
    private String msDesc;

    @NotNull(message = "参数codeLang不能为空")
    @Size(min=1, max = 20, message="微服务编程语言不应小于2字符，同时不应大于20字符")
    @ApiModelProperty(notes = "The coding language of this microservice")
    private String codeLang;

    @NotNull (message = "参数bIsRestWS不能为空")
    @ApiModelProperty(notes = "True if this microservice is a http server")
    private Boolean bIsRestWS;

    @ApiModelProperty(notes = "The http service port(optional)")
    private Integer servicePort;

    public MicroService() {
    }

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
