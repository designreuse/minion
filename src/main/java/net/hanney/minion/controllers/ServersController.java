package net.hanney.minion.controllers;

import net.hanney.minion.model.*;
import net.hanney.minion.service.NetworkService;
import net.hanney.minion.service.ServersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Primary Controller that handles all Servers-related functionality
 *
 * @author justin.hanney
 */
@Controller
@RequestMapping(value = "/servers")
public class ServersController extends AbstractController {

    static final String VIEW_VARIABLE_SERVERS                   = "servers";
    static final String VIEW_VARIABLE_OPERATING_SYSTEMS         = "operatingSystems";
    static final String VIEW_VARIABLE_SERVER_TYPES              = "serverTypes";
    static final String VIEW_VARIABLE_DATA_CENTERS              = "dataCenters";
    static final String VIEW_VARIABLE_DOMAINS                   = "domains";
    static final String VIEW_VARIABLE_VOLUMES                   = "volumes";

    @Autowired
    private NetworkService networkService;
    @Autowired
    private ServersService serversService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createServer(final @ModelAttribute Server server,
                                     final BindingResult bindingResult) {
        serversService.createServer(server);

        return showServers();
    }

    @RequestMapping(value = "/volume/create", method = RequestMethod.POST)
    public ModelAndView createServerVolume(final @ModelAttribute ServerVolume serverVolume,
                                           final BindingResult bindingResult) {
        serversService.createServerVolume(serverVolume);

        return showServers();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteServer(final @ModelAttribute Server server,
                                     final BindingResult bindingResult)
    {
        serversService.deleteServer(server);

        return showServers();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView editServer(final @ModelAttribute Server server,
                                   final BindingResult bindingResult) {
        serversService.editServer(server);

        return showServers();
    }

    @Override
    public NavbarItem getSelectedNavbarItem() {
        return NavbarItem.SERVERS;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return showServers();
    }

    @RequestMapping(value = "/{serverId}/delete", method = RequestMethod.GET)
    public ModelAndView showDeleteServer(final @PathVariable Long serverId)
    {
        final Server server = serversService.getServer(serverId);

        final ModelAndView mv = new ModelAndView("servers/deleteServer", "command", server);

        return mv;
    }

    @RequestMapping(value = "/{serverId}/edit", method = RequestMethod.GET)
    public ModelAndView showEditServer(final @PathVariable Long serverId) {
        final Server server = serversService.getServer(serverId);

        final ModelAndView mv = new ModelAndView("servers/editServer", "command", server);

        final List<OperatingSystem> operatingSystems = serversService.getOperatingSystems();
        mv.addObject(VIEW_VARIABLE_OPERATING_SYSTEMS, operatingSystems);

        final List<ServerType> serverTypes = serversService.getServerTypes();
        mv.addObject(VIEW_VARIABLE_SERVER_TYPES, serverTypes);

        final List<DataCenter> dataCenters = networkService.getActiveDataCenters();
        mv.addObject(VIEW_VARIABLE_DATA_CENTERS, dataCenters);

        final List<Domain> domains = networkService.getActiveDomains();
        mv.addObject(VIEW_VARIABLE_DOMAINS, domains);

        final List<ServerVolume> volumes = serversService.getServerVolumes(serverId);
        mv.addObject(VIEW_VARIABLE_VOLUMES, volumes);

        return mv;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView showNewServer() {
        final ModelAndView mv = new ModelAndView("servers/newServer", "command", new Server());

        final List<OperatingSystem> operatingSystems = serversService.getOperatingSystems();
        mv.addObject(VIEW_VARIABLE_OPERATING_SYSTEMS, operatingSystems);

        final List<ServerType> serverTypes = serversService.getServerTypes();
        mv.addObject(VIEW_VARIABLE_SERVER_TYPES, serverTypes);

        final List<DataCenter> dataCenters = networkService.getActiveDataCenters();
        mv.addObject(VIEW_VARIABLE_DATA_CENTERS, dataCenters);

        final List<Domain> domains = networkService.getActiveDomains();
        mv.addObject(VIEW_VARIABLE_DOMAINS, domains);

        return mv;
    }

    @RequestMapping(value = "/{serverId}/volume/new", method = RequestMethod.GET)
    public ModelAndView showNewServerVolume(final @PathVariable Long serverId) {
        final ServerVolume serverVolume = new ServerVolume();
        serverVolume.setServerId(serverId);

        return new ModelAndView("servers/newServerVolume", "command", serverVolume);
    }

    public ModelAndView showServers() {
        final ModelAndView mv = new ModelAndView("servers/showServers");

        // Load all of the active Servers
        final List<Server> servers = serversService.getServers();
        mv.addObject(VIEW_VARIABLE_SERVERS, servers);

        return mv;
    }

}
