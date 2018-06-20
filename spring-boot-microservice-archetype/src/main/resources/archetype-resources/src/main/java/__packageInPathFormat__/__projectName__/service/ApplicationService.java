package ${package}.${projectName}.service;


import ${package}.${projectName}.domain.entity.ApplicationItem;
import java.util.List;

/**
 * Sample service interface used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
public interface ApplicationService {

	/**
	 * Creates an application item.
	 * 
	 * @param applicationItem The application item to create.
	 */
    public void createApplicationItem(ApplicationItem applicationItem);

	/**
	 * Gets all the application items.
	 * 
	 * @return The list of application items.
	 */
    public List<ApplicationItem> getApplicationItems();

}
