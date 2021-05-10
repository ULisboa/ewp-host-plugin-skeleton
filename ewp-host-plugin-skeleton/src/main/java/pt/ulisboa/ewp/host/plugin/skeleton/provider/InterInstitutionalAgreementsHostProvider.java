package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.annotation.Nullable;

import eu.erasmuswithoutpaper.api.iias.v4.endpoints.IiasGetResponseV4;

/**
 * A provider that allows EWP Node to obtain the list of Inter Institutional Agreements from the host.
 */
public abstract class InterInstitutionalAgreementsHostProvider extends HostProvider {

    private static final int DEFAULT_MAX_NUMBER_IIA_IDS_PER_REQUEST = 1;
    private static final int DEFAULT_MAX_NUMBER_IIA_CODES_PER_REQUEST = 1;

    /**
     * Returns a collection of IIA IDs which the requester has access to.
     *
     * @param heiId Identifier of the HEI which we want to fetch the list of IIAs from.
     * @param partnerHeiId Identifier used to limit the list of returned IIA IDs to only those in which the partner HEI ID is one
     *            of the partners.
     * @param receivingAcademicYearIds If not null, the list of returned IIA IDs must only include those that are valid in at
     *            least one of the given academic years.
     * @param modifiedSince If not null, the list of returned IIA IDs must only include those that have been either created or
     *            modified after the given point in time.
     * @return Collection of IIA IDs.
     */
    public abstract Collection<String> findAllIiaIdsByHeiId(String heiId, @Nullable String partnerHeiId,
            Collection<String> receivingAcademicYearIds, LocalDateTime modifiedSince);

    /**
     * Returns a collection of IIAs given their IDs.
     * If some code is unknown then it must be ignored.
     *
     * @param heiId HEI ID of the institution that contains the intended IIAs.
     * @param iiaIds IIA IDs to obtain.
     * @param sendPdf If true, the response must include the PDF version of the agreement.
     * @return Collection of IIAs.
     */
    public abstract Collection<IiasGetResponseV4.Iia> findByHeiIdAndIiaIds(String heiId, Collection<String> iiaIds,
            @Nullable Boolean sendPdf);

    /**
     * Returns a collection of IIAs given their codes.
     * If some code is unknown then it must be ignored.
     *
     * @param heiId HEI ID of the institution that contains the intended IIAs.
     * @param iiaCodes IIA codes to obtain.
     * @param sendPdf If true, the response must include the PDF version of the agreement.
     * @return Collection of IIAs.
     */
    public abstract Collection<IiasGetResponseV4.Iia> findByHeiIdAndIiaCodes(String heiId, Collection<String> iiaCodes,
            @Nullable Boolean sendPdf);

    /**
     * Indicates the maximum number of IIA IDs that can be handled on any request.
     * 
     * @return Maximum number of IIA IDs
     */
    public int getMaxIiaIdsPerRequest() {
        return DEFAULT_MAX_NUMBER_IIA_IDS_PER_REQUEST;
    }

    /**
     * Indicates the maximum number of IIA codes that can be handled on any request.
     * 
     * @return Maximum number of IIA codes
     */
    public int getMaxIiaCodesPerRequest() {
        return DEFAULT_MAX_NUMBER_IIA_CODES_PER_REQUEST;
    }
}
