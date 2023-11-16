package pt.ulisboa.ewp.host.plugin.skeleton.provider.iias.approval;

import eu.erasmuswithoutpaper.api.iias.approval.v2.IiasApprovalResponseV2;
import java.util.Collection;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain data about Inter Institutional Agreements' approvals
 * from the host (V2).
 */
public abstract class InterInstitutionalAgreementsApprovalV2HostProvider extends
    HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_IIA_IDS_PER_REQUEST = 1;

    /**
     * Returns a collection of IIAs approvals given their IDs. If some ID is unknown or unapproved
     * then it must be ignored.
     *
     * @param approvingHeiId        HEI ID of the approving institution (the target of the
     *                              operation).
     * @param requesterCoveredHeiId HEI ID of the requester that wants to get approvals.
     * @param iiaIds                IIA IDs to obtain.
     * @return Collection of IIAs.
     */
    public abstract Collection<IiasApprovalResponseV2.Approval> findByIiaIds(String approvingHeiId,
        String requesterCoveredHeiId,
        Collection<String> iiaIds);

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
        return "2.0.0";
    }
}
