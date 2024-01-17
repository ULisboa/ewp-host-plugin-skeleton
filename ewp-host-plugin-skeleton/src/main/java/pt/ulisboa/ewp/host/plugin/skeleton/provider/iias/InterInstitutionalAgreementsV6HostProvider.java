package pt.ulisboa.ewp.host.plugin.skeleton.provider.iias;

import eu.erasmuswithoutpaper.api.iias.v6.endpoints.IiasStatsResponseV6;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.annotation.Nullable;

import eu.erasmuswithoutpaper.api.iias.v6.endpoints.IiasGetResponseV6;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain the list of Inter Institutional Agreements from the host (V6).
 */
public abstract class InterInstitutionalAgreementsV6HostProvider extends HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_IIA_IDS_PER_REQUEST = 1;
    private static final int DEFAULT_MAX_NUMBER_IIA_CODES_PER_REQUEST = 1;

    /**
     * Returns a collection of IIA IDs which the requester has access to.
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the IIAs to
     *            which some covered HEI ID has access to.
     * @param heiId Identifier of the HEI which we want to fetch the list of IIAs from.
     * @param partnerHeiId If not null, the identifier used to limit the list of returned IIA IDs to only those in which the partner HEI ID is one
     *            of the partners.
     * @param receivingAcademicYearIds If not null, the list of returned IIA IDs must only include those that are valid in at
     *            least one of the given academic years.
     * @param modifiedSince If not null, the list of returned IIA IDs must only include those that have been either created or
     *            modified after the given point in time.
     * @return Collection of IIA IDs.
     */
    public abstract Collection<String> findAllIiaIdsByHeiId(Collection<String> requesterCoveredHeiIds, String heiId,
            @Nullable String partnerHeiId, @Nullable Collection<String> receivingAcademicYearIds, @Nullable LocalDateTime modifiedSince);

    /**
     * Returns a collection of IIAs given their IDs.
     * If some code is unknown then it must be ignored.
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the IIAs to
     *            which some covered HEI ID has access to.
     * @param heiId HEI ID of the institution that contains the intended IIAs.
     * @param iiaIds IIA IDs to obtain.
     * @param sendPdf If given and true, the response must include the PDF version of the agreement.
     * @return Collection of IIAs.
     */
    public abstract Collection<IiasGetResponseV6.Iia> findByHeiIdAndIiaIds(Collection<String> requesterCoveredHeiIds,
            String heiId, Collection<String> iiaIds, @Nullable Boolean sendPdf);

    /**
     * Returns a collection of IIAs given their codes.
     * If some code is unknown then it must be ignored.
     *
     * @param requesterCoveredHeiIds List of HEI IDs covered by the requester. The result should be restricted to the IIAs to
     *            which some covered HEI ID has access to.
     * @param heiId HEI ID of the institution that contains the intended IIAs.
     * @param iiaCodes IIA codes to obtain.
     * @param sendPdf If given and true, the response must include the PDF version of the agreement.
     * @return Collection of IIAs.
     */
    public abstract Collection<IiasGetResponseV6.Iia> findByHeiIdAndIiaCodes(Collection<String> requesterCoveredHeiIds,
            String heiId, Collection<String> iiaCodes, @Nullable Boolean sendPdf);

    /**
     * Returns the stats relative to the provided HEI ID.
     *
     * @param heiId HEI ID of the institution from which to retrieve its stats.
     * @return Stats of the provided HEI
     */
    public abstract IiasStatsResponseV6 getStats(String heiId);

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

    @Override
    public String getVersion() {
        return "6.3.0";
    }
}
