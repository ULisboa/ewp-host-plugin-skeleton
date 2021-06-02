package pt.ulisboa.ewp.host.plugin.demo.providers;

import eu.erasmuswithoutpaper.api.architecture.v1.StringWithOptionalLangV1;
import eu.erasmuswithoutpaper.api.institutions.v2.InstitutionsResponseV2;
import eu.erasmuswithoutpaper.api.institutions.v2.InstitutionsResponseV2.Hei;
import java.util.Optional;
import org.pf4j.Extension;
import pt.ulisboa.ewp.host.plugin.demo.DemoHostPlugin;
import pt.ulisboa.ewp.host.plugin.skeleton.provider.institutions.InstitutionsV2HostProvider;

@Extension
public class DemoInstitutionsV2Provider extends InstitutionsV2HostProvider {

  @Override
  public Optional<InstitutionsResponseV2.Hei> findByHeiId(String heiId) {
    // Example: Obtain a property registered on EWP Node specific for the current plugin
    String propertyValue = DemoHostPlugin.getInstance().getProperties().getPropertyAsString("example.key");
    System.out.println("Obtained property value: " + propertyValue);

    if (heiId.equals("example.com")) {
      Hei hei = new Hei();
      hei.setHeiId("example.com");
      StringWithOptionalLangV1 stringWithOptionalLang = new StringWithOptionalLangV1();
      stringWithOptionalLang.setLang("en");
      stringWithOptionalLang.setValue("Demo");
      hei.getName().add(stringWithOptionalLang);
      return Optional.of(hei);
    }
    return Optional.empty();
  }
}
