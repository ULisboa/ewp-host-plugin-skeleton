package pt.ulisboa.ewp.host.plugin.skeleton.provider.files;

import java.io.Serializable;

public class FileResponse implements Serializable {

    private final String mediaType;
    private final byte[] data;

    public FileResponse(String mediaType, byte[] data) {
        this.mediaType = mediaType;
        this.data = data;
    }

    public String getMediaType() {
        return mediaType;
    }

    public byte[] getData() {
        return data;
    }

}
