package pt.ulisboa.ewp.host.plugin.skeleton.provider.iias;

import eu.erasmuswithoutpaper.api.iias.v7.endpoints.IiasGetResponseV7;
import eu.erasmuswithoutpaper.api.iias.v7.endpoints.IiasStatsResponseV7;
import java.time.LocalDateTime;
import java.util.Collection;
import javax.annotation.Nullable;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain the list of Inter Institutional Agreements from the host (V7).
 */
public abstract class InterInstitutionalAgreementsV7HostProvider extends HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_IIA_IDS_PER_REQUEST = 1;

    /**
     * Returns a collection of IIA IDs which the requester has access to.
     *
     * @param requesterCoveredHeiId HEI ID of the requester. The result should be restricted to the IIAs to
     *            which that HEI ID has access to.
     * @param heiId Identifier of the HEI which we want to fetch the list of IIAs from.
     * @param receivingAcademicYearIds If not null, the list of returned IIA IDs must only include those that are valid in at
     *            least one of the given academic years.
     * @param modifiedSince If not null, the list of returned IIA IDs must only include those that have been either created or
     *            modified after the given point in time.
     * @return Collection of IIA IDs.
     */
    public abstract Collection<String> findAllIiaIdsByHeiId(String requesterCoveredHeiId, String heiId,
            @Nullable Collection<String> receivingAcademicYearIds, @Nullable LocalDateTime modifiedSince);

    /**
     * Returns a collection of IIAs given their IDs.
     * If some ID is unknown then it must be ignored.
     *
     * @param requesterCoveredHeiId HEI ID of the requester. The result should be restricted to the IIAs to
     *            which that HEI ID has access to.
     * @param heiId HEI ID of the institution that contains the intended IIAs.
     * @param iiaIds IIA IDs to obtain.
     * @return Collection of IIAs.
     */
    public abstract Collection<IiasGetResponseV7.Iia> findByHeiIdAndIiaIds(String requesterCoveredHeiId,
            String heiId, Collection<String> iiaIds);

    /**
     * Returns the stats relative to the provided HEI ID.
     *
     * @param heiId HEI ID of the institution from which to retrieve its stats.
     * @return Stats of the provided HEI
     */
    public abstract IiasStatsResponseV7 getStats(String heiId);

    /**
     * Indicates the maximum number of IIA IDs that can be handled on any request.
     *
     * @return Maximum number of IIA IDs
     */
    public int getMaxIiaIdsPerRequest() {
        return DEFAULT_MAX_NUMBER_IIA_IDS_PER_REQUEST;
    }

    @Override
    public String getVersion() {
        return "7.0.0";
    }
}
