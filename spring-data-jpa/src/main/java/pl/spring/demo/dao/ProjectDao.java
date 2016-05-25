/**
 * 
 */
package pl.spring.demo.dao;

import pl.spring.demo.entity.ProjectEntity;

/**
 * @author HSIENKIE
 *
 */

public interface ProjectDao extends Dao<ProjectEntity, Long> {

	ProjectEntity findProjectByName(String projectName);

}
