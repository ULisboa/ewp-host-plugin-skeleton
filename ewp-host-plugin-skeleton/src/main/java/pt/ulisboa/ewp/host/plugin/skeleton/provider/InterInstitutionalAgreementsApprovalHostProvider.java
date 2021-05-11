package pt.ulisboa.ewp.host.plugin.skeleton.provider;

import eu.erasmuswithoutpaper.api.iias.approval.v1.IiasApprovalResponseV1;
import java.util.Collection;
import javax.annotation.Nullable;

/**
 * A provider that allows EWP Node to obtain data about Inter Institutional Agreements' approvals from the host.
 */
public abstract class InterInstitutionalAgreementsApprovalHostProvider extends HostProvider {

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
}
