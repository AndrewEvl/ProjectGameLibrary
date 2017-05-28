package entities;

/**
 * Created by User on 23.05.2017.
 */
public class SystemSetting {

    private String cpu;
    private String ram;
    private String hdd;
    private String video;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemSetting systemSetting = (SystemSetting) o;

        if (cpu != null ? !cpu.equals(systemSetting.cpu) : systemSetting.cpu != null) return false;
        if (ram != null ? !ram.equals(systemSetting.ram) : systemSetting.ram != null) return false;
        if (hdd != null ? !hdd.equals(systemSetting.hdd) : systemSetting.hdd != null) return false;
        return video != null ? video.equals(systemSetting.video) : systemSetting.video == null;
    }

    @Override
    public int hashCode() {
        int result = cpu != null ? cpu.hashCode() : 0;
        result = 31 * result + (ram != null ? ram.hashCode() : 0);
        result = 31 * result + (hdd != null ? hdd.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        return result;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
