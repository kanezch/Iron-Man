package me.kanezheng.maintainer;

import java.util.Objects;

public class MicroService {
    private String msname;
    private String msteam;
    private String msmaintainer;
    private String description;

    public MicroService() {
    }

    public MicroService(String msname, String msteam, String msmaintainer, String description) {
        this.msname = msname;
        this.msteam = msteam;
        this.msmaintainer = msmaintainer;
        this.description = description;
    }

    public String getMsname() {
        return msname;
    }

    public void setMsname(String msname) {
        this.msname = msname;
    }

    public String getMsteam() {
        return msteam;
    }

    public void setMsteam(String msteam) {
        this.msteam = msteam;
    }

    public String getMsmaintainer() {
        return msmaintainer;
    }

    public void setMsmaintainer(String msmaintainer) {
        this.msmaintainer = msmaintainer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {return false;}
        MicroService that = (MicroService) o;
        return Objects.equals(msname, that.msname) &&
                Objects.equals(msteam, that.msteam) &&
                Objects.equals(msmaintainer, that.msmaintainer) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(msname, msteam, msmaintainer, description);
    }
}
