package atps_company.pilkadaciamis2018.model;

import java.io.Serializable;

/**
 * Created by emerio on 11/6/17.
 */

public class Dokumen implements Serializable{

    String fileName;
    String filePath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
