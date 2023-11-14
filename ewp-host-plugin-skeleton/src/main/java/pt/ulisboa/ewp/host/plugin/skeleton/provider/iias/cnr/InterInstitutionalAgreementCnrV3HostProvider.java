package pt.ulisboa.ewp.host.plugin.skeleton.provider.iias.cnr;

import pt.ulisboa.ewp.host.plugin.skeleton.provider.HostVersionedProvider;

/**
 * A provider that allows EWP Node to notify a host about a change notification on some IIA kept by some partner
 * institution (V3).
 */
public abstract class InterInstitutionalAgreementCnrV3HostProvider extends HostVersionedProvider {

    /**
     * Called upon a change notification of an IIA emitted by some partner institutions.
     *
     * @see <a href="https://github.com/erasmus-without-paper/ewp-specs-api-iia-cnr/tree/stable-v3">EWP
     *      Specification</a>
     *
     * @param notifierHeiId Identifier of the HEI which has recently updated their copy of the IIA.
     * @param iiaId Identifier of the IIA which has recently been changed.
     */
    public abstract void onChangeNotification(String notifierHeiId, String iiaId);

    @Override
    public String getVersion() {
        return "3.0.0";
    }
}
