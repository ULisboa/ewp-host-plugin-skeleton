package pt.ulisboa.ewp.host.plugin.skeleton.provider.iias.approval;

import eu.erasmuswithoutpaper.api.iias.approval.v1.IiasApprovalResponseV1;
import java.util.Collection;
import javax.annotation.Nullable;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to obtain data about Inter Institutional Agreements' approvals from the host (V1).
 */
public abstract class InterInstitutionalAgreementsApprovalV1HostProvider extends
    HostVersionedProvider {

    private static final int DEFAULT_MAX_NUMBER_IIA_IDS_PER_REQUEST = 1;

    /**
     * Returns a collection of IIAs approvals given their IDs.
     * If some ID is unknown or unapproved then it must be ignored.
     *
     * @param approvingHeiId HEI ID of the approving institution (the target of the operation).
     * @param ownerHeiId HEI ID of the requester that wants to get approvals.
     * @param iiaIds IIA IDs to obtain.
     * @param sendPdf If true, the response must include the PDF version of the agreement.
     * @return Collection of IIAs.
     */
    public abstract Collection<IiasApprovalResponseV1.Approval> findByIiaIds(String approvingHeiId, String ownerHeiId,
            Collection<String> iiaIds, @Nullable Boolean sendPdf);

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
        return "1.0.0";
    }
}
