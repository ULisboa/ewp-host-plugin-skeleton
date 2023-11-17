package pt.ulisboa.ewp.host.plugin.skeleton.provider.iias.approval.cnr;

import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to notify a host about a change notification of an approval of some IIA kept by some partner
 * institution (V2).
 */
public abstract class InterInstitutionalAgreementApprovalCnrV2HostProvider extends HostVersionedProvider {

    /**
     * Called upon a change notification of an approval of an IIA emitted by some partner institutions.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-iia-approval-cnr/tree/stable-v2">EWP
     *      Specification</a>
     *
     * @param approvingHeiId Identifier of the HEI which has recently approved the partner's copy of the IIA.
     * @param ownerHeiId Identifier of the HEI which is the owner of the copy of the agreement, that has been approved.
     * @param iiaId Partner's identifier of the IIA which has been approved.
     */
    public abstract void onChangeNotification(String approvingHeiId, String ownerHeiId, String iiaId);

    @Override
    public String getVersion() {
        return "2.0.0";
    }
}
