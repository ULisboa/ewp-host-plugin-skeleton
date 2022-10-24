package pt.ulisboa.ewp.host.plugin.skeleton.provider.files;

import java.util.Optional;

import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain files from the host (V1).
 */
public abstract class FilesV1HostProvider extends HostVersionedProvider {

    /**
     * Returns a file data whose ID was previously shared with the requester.
     * The file data must have an adequate media type value.
     * The files are immutable.
     *
     * If the file requested does not exist then an Optional.empty() must be returned.
     *
     * @param fileId ID of the file to return.
     * @return File data.
     */
    public abstract Optional<FileResponse> getFile(String fileId);

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    public static class FileResponse {

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
}
