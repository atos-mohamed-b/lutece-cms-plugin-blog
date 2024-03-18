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
package fr.paris.lutece.plugins.blog.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.plugins.blog.business.Blog;
import fr.paris.lutece.plugins.blog.service.BlogService;
import fr.paris.lutece.plugins.blog.service.archive.BlogArchiveService;
import fr.paris.lutece.plugins.blog.utils.BlogUtils;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.portal.util.mvc.admin.annotations.Controller;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.portal.web.constants.Parameters;
import fr.paris.lutece.portal.web.util.LocalizedPaginator;
import fr.paris.lutece.util.html.AbstractPaginator;
import fr.paris.lutece.util.html.Paginator;
import fr.paris.lutece.util.url.UrlItem;

/**
 * This class provides the user interface to manage archived Blog posts ( view, remove, etc. )
 * 
 */
@Controller( controllerJsp = "ManageBlogArchives.jsp", controllerPath = "jsp/admin/plugins/blog/", right = "BLOG_ARCHIVES_MANAGEMENT" )
public class ManageBlogArchivesJspBean extends ManageBlogJspBean
{
    private static final long serialVersionUID = 573298823765419766L;

    // JSP used for this class
    private static final String JSP_MANAGE_BLOG_ARCHIVES = "jsp/admin/plugins/blog/ManageBlogArchives.jsp";

    // Views
    private static final String VIEW_MANAGE_BLOG_ARCHIVES = "manageBlogArchives";

    // Templates
    private static final String TEMPLATE_MANAGE_BLOG_ARCHIVES = "admin/plugins/blog/manage_blog_archives.html";

    // Properties
    private static final String PROPERTY_DEFAULT_LIST_ITEM_PER_PAGE = "blog.listItems.itemsPerPage";
    private static final String PROPERTY_PAGE_TITLE_MANAGE_BLOG_ARCHIVES = "blog.manage_blog_archives.pageTitle";

    // Marks
    private static final String MARK_ARCHIVED_BLOG_LIST = "archived_blogs_list";
    private static final String MARK_PAGINATOR = "paginator";
    private static final String MARK_NB_ITEMS_PER_PAGE = "nb_items_per_page";

    // Session variables
    private String _strCurrentPageIndex;
    private int _nItemsPerPage;
    private int _nDefaultItemsPerPage;

    /**
     * Build and display the View to manage archived blog posts
     * 
     * @param request
     *            The HTTP request
     * @return the page's content
     */
    @View( value = VIEW_MANAGE_BLOG_ARCHIVES, defaultView = true )
    public String getManageBlogArchives( HttpServletRequest request )
    {
        _strCurrentPageIndex = AbstractPaginator.getPageIndex( request, Paginator.PARAMETER_PAGE_INDEX, _strCurrentPageIndex );
        _nDefaultItemsPerPage = AppPropertiesService.getPropertyInt( PROPERTY_DEFAULT_LIST_ITEM_PER_PAGE, 50 );
        _nItemsPerPage = AbstractPaginator.getItemsPerPage( request, Paginator.PARAMETER_ITEMS_PER_PAGE, _nItemsPerPage, _nDefaultItemsPerPage );

        // Get the sorting parameters
        String strSortedAttributeName = request.getParameter( Parameters.SORTED_ATTRIBUTE_NAME );
        String strAscSort = request.getParameter( Parameters.SORTED_ASC );

        // Get the List of IDs of all the archived posts
        List<Integer> listArchivedBlogIds = BlogArchiveService.getListArchivedBlogPostIds( );

        UrlItem url = new UrlItem( JSP_MANAGE_BLOG_ARCHIVES );

        // Set the list of blog IDs in the paginator
        LocalizedPaginator<Integer> paginator = new LocalizedPaginator<>( listArchivedBlogIds, _nItemsPerPage, url.getUrl( ), Paginator.PARAMETER_PAGE_INDEX,
                _strCurrentPageIndex, getLocale( ) );

        // Get the list of archived blogs
        List<Blog> listArchivedBlogs = getArchivedBlogsListFromPaginator( paginator );

        // Sort the List of blogs
        BlogUtils.sortBlogList( listArchivedBlogs, strSortedAttributeName, strAscSort );

        Map<String, Object> model = new HashMap<>( );
        model.put( MARK_ARCHIVED_BLOG_LIST, listArchivedBlogs );
        model.put( MARK_PAGINATOR, paginator );
        model.put( MARK_NB_ITEMS_PER_PAGE, String.valueOf( _nItemsPerPage ) );

        return getPage( PROPERTY_PAGE_TITLE_MANAGE_BLOG_ARCHIVES, TEMPLATE_MANAGE_BLOG_ARCHIVES, model );
    }

    /**
     * Get the List of archived blogs from a paginator
     * 
     * @param paginator
     *            Parginator used to retrieve the blogs' IDs
     * @return a List of archived Blog Objects
     */
    private List<Blog> getArchivedBlogsListFromPaginator( LocalizedPaginator<Integer> paginator )
    {
        List<Blog> listBlogs = new ArrayList<>( );

        for ( Integer blogId : paginator.getPageItems( ) )
        {
            // TODO set proper service
            Blog blog = BlogService.getInstance( ).findByPrimaryKeyWithoutBinaries( blogId );

            if ( blog != null )
            {
                listBlogs.add( blog );
            }
        }
        return listBlogs;
    }
}
