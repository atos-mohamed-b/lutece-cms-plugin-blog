/*
 * Copyright (c) 2002-2024, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.blog.service.archive;

import java.util.List;
import java.util.Locale;

import fr.paris.lutece.plugins.blog.business.Blog;
import fr.paris.lutece.plugins.blog.business.archive.BlogArchiveHome;
import fr.paris.lutece.plugins.blog.service.BlogPlugin;
import fr.paris.lutece.portal.service.rbac.Permission;
import fr.paris.lutece.portal.service.rbac.ResourceIdService;
import fr.paris.lutece.portal.service.rbac.ResourceType;
import fr.paris.lutece.portal.service.rbac.ResourceTypeManager;
import fr.paris.lutece.util.ReferenceList;

/*
 * Service used to manage the control on blog posts' archiving - Displayed when adding a new control to a role
 * 
 */
public class BlogArchiveResourceIdService //extends ResourceIdService
{
    // Permission properties
   // private static final String PROPERTY_LABEL_RESOURCE_TYPE = "blog.rbac.archive.resourceType";
   // private static final String PROPERTY_LABEL_VIEW = "blog.rbac.archive.permission.view";
    //private static final String PROPERTY_LABEL_ARCHIVE = "blog.rbac.archive.permission.archive";

    /**
     * {@inheritDoc}
     */
   /* @Override
    public void register( )
    {
        // Create a resource for the archiving of Blog posts
        ResourceType rt = new ResourceType( );
        rt.setResourceIdServiceClass( BlogArchiveResourceIdService.class.getName( ) );
        rt.setPluginName( BlogPlugin.PLUGIN_NAME );
        rt.setResourceTypeKey( BlogArchiveResource.PROPERTY_RESOURCE_TYPE );
        rt.setResourceTypeLabelKey( PROPERTY_LABEL_RESOURCE_TYPE );

        // Permission to view archived blog posts
        Permission permissionViewArchive = new Permission( );
        permissionViewArchive.setPermissionKey( BlogArchiveResource.PERMISSION_VIEW );
        permissionViewArchive.setPermissionTitleKey( PROPERTY_LABEL_VIEW );
        rt.registerPermission( permissionViewArchive );

        // Permission to archive a blog post
        //Permission permissionArchivePost = new Permission( );
        //permissionArchivePost.setPermissionKey( BlogArchiveResource.PERMISSION_ARCHIVE );
        //permissionArchivePost.setPermissionTitleKey( PROPERTY_LABEL_ARCHIVE );
        //rt.registerPermission( permissionArchivePost );

        // Register the resource type created for archiving blog posts, to be used by the RBAC service
        ResourceTypeManager.registerResourceType( rt );
    }*/

    /**
     * {@inheritDoc}
     */
    /*@Override
    public ReferenceList getResourceIdList( Locale locale )
    {
        // Return a List of all the resources (blog posts) that can be controlled
        List<Blog> listArchivedPosts = BlogArchiveHome.getListArchivedBlogPosts( );
        return ReferenceList.convert( listArchivedPosts, "id", "name", true );
    }*/

    /**
     * {@inheritDoc}
     */
    /*@Override
    public String getTitle( String strId, Locale locale )
    {
        Blog resource = BlogArchiveHome.findByPrimaryKey( Integer.parseInt( strId ) );
        return resource.getName( );
    }*/
}
