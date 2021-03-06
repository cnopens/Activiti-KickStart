/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.kickstart;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * @author jbarrez
 */
public class KickstartApplication extends Application {
  
  @Override
  public synchronized Restlet createInboundRoot() {
    Router router = new Router(getContext());

    router.attach("/workflow", WorkflowResource.class);
    router.attach("/workflow/{workflowId}", WorkflowResource.class);
    router.attach("/workflow/{workflowId}/image", WorkflowImageResource.class);
    router.attach("/workflow/{workflowId}/metadata/{metaDataKey}", WorkflowMetaDataResource.class);
    
    router.attach("/workflows", WorkflowsResource.class);
    
    router.attach("/groups", GroupsResource.class);
    router.attach("/users", UsersResource.class);
    router.attach("/users/{filter}", UsersResource.class);
    
    return router;
  }
  
}
