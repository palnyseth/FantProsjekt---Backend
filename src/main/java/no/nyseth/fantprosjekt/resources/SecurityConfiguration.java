/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.nyseth.fantprosjekt.resources;

import javax.annotation.security.DeclareRoles;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import no.nyseth.fantprosjekt.auth.Group;
import org.eclipse.microprofile.auth.LoginConfig;

/**
 *
 * @author mikael
 */
@DatabaseIdentityStoreDefinition(
    dataSourceLookup=DatasourceProducer.JNDI_NAME,
    callerQuery="select password from auser where userid = ?",
    groupsQuery="select name from ausergroup where userid  = ?",
    hashAlgorithm = PasswordHash.class,
    priority = 80)
@DeclareRoles({Group.ADMIN,Group.USER})
@LoginConfig(authMethod = "MP-JWT",realmName = "template")
public class SecurityConfiguration {    
}
