package com.demoapplication.demoapplication;
// import java.util.HashSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoapplication.demoapplication.model.Role;
import com.demoapplication.demoapplication.model.User;
import com.demoapplication.demoapplication.repository.RoleRepository;
import com.demoapplication.demoapplication.repository.UserRepository;
import com.demoapplication.demoapplication.service.SecurityService;
import com.demoapplication.demoapplication.service.UserService;
import com.demoapplication.demoapplication.validator.UserValidator;
import org.apache.tomcat.util.buf.StringCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class form_controller {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    customers_repo repo;

    @Autowired
    invoice_repo repoi;

    @Autowired
    material_repo repom;

    @Autowired
    material_supplier_repo repoms;

    @Autowired
    supplier_repo repos;

    @Autowired
    UserRepository userrepo;

    @Autowired
    RoleRepository rolerepo;

    // Long id = (long) 0;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        System.out.println(userForm.getUser_type());

        // Role role = new Role();
        // Set<Role> roleset = new HashSet<Role>();
        // Set<User> userset = new HashSet<User>();
        // roleset.add(role);
        // userset.add(userForm);
        // if (userForm.getUser_type().equals("customer")) {
            // role.setName("ROLE_USER");
            // role.setName("ROLE_USER");
            // Set<Role> roleset = new HashSet<>();
            // roleset.add(rolerepo.findByName("ROLE_USER").orElseGet(() -> {
            //     Role role = new Role();
            //     role.setName("ROLE_USER");
            //     return rolerepo.save(role);
            // }));
            // Optional<Role> roleHolder = rolerepo.findByName("ROLE_USER");
            // Role role = null;
            // if (roleHolder.isPresent()) {
            //     role = roleHolder.get();
            // } else {
            //     // Role newRole = new Role();
            //     role = new Role();
            //     role.setName("ROLE_USER");
            //     role = rolerepo.save(role);
            // }
            // role = rolerepo.save(role);
            // role.setUsers(userset);
            // roleset.add(role);
            // userForm.setRoles(roleset);
            // userForm.getRoles().add(role);
            // userset.add(userForm);
            // userService.save(userForm);
            // System.out.println("Inside customer if else block");
        //     return "redirect:/login";
        // } else if (userForm.getUser_type().equals("supplier")) {
        //     // role.setName("ROLE_ADMIN");
        //     Set<Role> roleset = new HashSet<>();
        //     roleset.add(rolerepo.findByName("ROLE_ADMIN").orElseGet(() -> {
        //         Role role = new Role();
        //         role.setName("ROLE_ADMIN");
        //         return rolerepo.save(role);
        //     }));
            // Optional<Role> roleHolder = rolerepo.findByName("ROLE_ADMIN");
            // Role role = null;
            // if (roleHolder.isPresent()) {
            //     role = roleHolder.get();
            // } else {
            //     role = new Role();
            //     role.setName("ROLE_ADMIN");
            //     role = rolerepo.save(role);
            // }            
            // role.setName("ROLE_ADMIN");
            // role = rolerepo.save(role);
            // roleset.add(role);
            // userForm.setRoles(roleset);
            // userForm.getRoles().add(role);
            // role.setUsers(userset);
            // userService.save(userForm);
            // System.out.println("Inside supplier if else block");
            // return "redirect:/login";
        // }
        // securityService.autoLogin(userForm.getUsername(),
        // userForm.getPasswordConfirm());
        userService.save(userForm);
        return "redirect:/login";
        // return "redirect:/mainpage";
    }

    @GetMapping(value = "/logout-success")
    public String getLogoutPage(Model model) {
        return "logout";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        // System.out.println("In first login form" + user);
        System.out.println("In first login form" + model);
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/mainpage", method = RequestMethod.POST)
    public String main() {
        return "mainpage";
    }

    @Controller
    @RequestMapping("/logout")
    public class LogoutController {
        @RequestMapping(method = RequestMethod.POST)
        public String logout(HttpServletRequest request,HttpServletResponse response) {
            HttpSession session= request.getSession(false);
            SecurityContextHolder.clearContext();
            session= request.getSession(false);
            if(session != null) {
                session.invalidate();
            }
            for(Cookie cookie : request.getCookies()) {
                cookie.setMaxAge(0);
            }

    return "redirect:/login";
            // session.invalidate();
            // return "redirect:/login";
        }
    }

    @Controller
    @RequestMapping("/logout-success")
    public class LogoutController2 {
        @RequestMapping(method = RequestMethod.POST)
        public String logout(HttpSession session) {
            session.invalidate();
            return "redirect:/login";
        }
    }

    // @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user , BindingResult
    bindingResult , ModelMap model){
    userValidator.validate(user, bindingResult);

    if (bindingResult.hasErrors()) {
    return "login";
    }

    System.out.println("In login form" + user);
    if(user.getUser_type().equals("customer"))
    {
        return "welcome_customer";
    }
    else if(user.getUser_type().equals("supplier"))
    {
        return "welcome_supplier";
    }

    // Role role = new Role();
    // if(user.getRoles().contains(new Role()))
    // model.addAttribute("name", user.getUsername());
    // System.out.println("This is "+user.getUsername());
    // System.out.println("Tstfiug");
    // String username = model.getUsername();
    // String username = model.getAttribute("Username").toString();
    // String password = model.getAttribute("Password").toString();

    // System.out.println(username);
    // User temp = userService.findByUsername(username);
    // System.out.println(temp.getR());
    // if(temp==null)
    // return "Invalid credentials";
    // else if(temp.getR()=="customer")
    // return "redirect:/welcome_customer";
    // else if(temp.getR()=="supplier")
    // return "redirect:/welcome_supplier";
    // else
    // return null;
    // userrepo.save(user);
    User temp = userService.findByUsername(user.getUsername().toString());
    System.out.println("This is"+temp.getUser_type());
    if(temp.getUser_type().equals("customer"))
    return "redirect:/welcome_customer";
    else
    return "redirect:/welcome_supplier";

    // return "login";
    }

    @GetMapping("/welcome_customer")
    public String welcome_customer(Model model) {
        return "welcome_customer";
    }

    @GetMapping("/welcome_supplier")
    public String welcome_supplier(Model model) {
        return "welcome_supplier";
    }

    @GetMapping("/mainpage")
    public String mainpage() {
        return "mainpage";
    }

    // @PreAuthorize("$cust_id == authentication.principal.cust_id")
    // @Secured("ROLE_USER")
    // @PreAuthorize("#userForm.username == principal.username")
    @GetMapping("/customers_form")
    public String customers(@ModelAttribute("userForm") User userForm, ModelMap model) {
        // System.out.println(userForm.getUsername());
        // System.out.println(model);
        // System.out.println(customers_repo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        User user = new User();
        user = userrepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Long id = user.getUser_id();
        model.put("id", id);
        System.out.println(id);
        // String username =
        // SecurityContextHolder.getContext().getAuthentication().getName();
        // for(customers objectc: repo.findAll())
        // {
        // if(objectc.get
        // {
        // objectm_s = objectms;
        // break;
        // }
        // }
        return "customer_form";
    }

    // @Secured("ROLE_USER")
    @GetMapping("/material_form")
    public String material() {
        return "material_form";
    }

    // @Secured("ROLE_ADMIN")
    @GetMapping("/material_supplier_form")
    public String material_supplier(Model model) {
        User user = new User();
        user = userrepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Long suppl_id = user.getUser_id();
        ((HashMap<String, Object>) model).put("suppl_id", suppl_id);
        return "material_supplier_form";
    }

    // @PreAuthorize("supplier.id == principal.id")
    // @Secured("ROLE_ADMIN")
    @GetMapping("/supplier_form")
    public String supplier(supplier supplier , Model model) {
        User user = new User();
        user = userrepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Long suppli_id = user.getUser_id();
        ((HashMap<String, Object>) model).put("suppli_id", suppli_id);
        return "supplier_form";
    }

    @PostMapping("/details_customer")
    @ResponseBody
    public List<customers> viewdetails_customer(customers customers) {
        System.out.println(customers);
        User user = new User();
        user = userrepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Long cid = user.getUser_id();
        Integer cust_id = Math.toIntExact(cid);
        customers.setCust_id(cust_id); 
        repo.save(customers);
        List<customers> cl = new ArrayList<customers>();
        repo.findAll().stream().forEach(cust -> {
            cl.add(cust);
        });
        return cl;
    }

    // @Secured("ROLE_USER")
    @GetMapping("/get_details")
    public ModelAndView invoice(Model model) {
        invoice_class invoiceo = new invoice_class();
        ModelAndView modelAndView = new ModelAndView("invoice_form", "command", invoiceo);
        User user = new User();
        user = userrepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        long invoic_id = user.getUser_id();
        int invoi_id = (int) invoic_id;
        ((HashMap<String, Object>) model).put("invoi_id", invoi_id);
	  return modelAndView;
    }

    @ModelAttribute("suppli")
    public List<Integer> suppli()
    { 
        List<Integer> suppli = new ArrayList<Integer>();
        repos.findAll().stream().forEach(s->suppli.add(s.getSupp_id()));
        return suppli;
    }

    @ModelAttribute("materi")
    public List<Integer> materi()
    {
        List<Integer> materi = new ArrayList<Integer>();
        repom.findAll().stream().forEach(m->materi.add(m.getMat_id()));
        return materi;
    }
    
    @PostMapping("/details_invoice")
    @ResponseBody
    public ResponseEntity<String> viewdetails_invoice(@ModelAttribute("invoice_class")invoice_class invoiceo, 
    ModelMap model, invoice invoice , @RequestParam Integer supp_id , @RequestParam Integer mat_id, @RequestParam Integer unit_purchased)
    {   
        String status[]= new String[1];
        status[0]="No";      
        supplier objects = new supplier();
        material objectm = new material();
        material_supplier objectm_s = new material_supplier();
        invoice object = new invoice();
        User user = new User();
        user = userrepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Long iid = user.getUser_id();
        Integer iiid = Math.toIntExact(iid);
        invoiceo.setCust_id(iiid);
        objects.setSupp_id(supp_id);
        objectm.setMat_id(mat_id);
        invoice.setSupplier(objects);
        invoice.setMaterial(objectm);

        objects = repos.findById(supp_id).get();
        objectm = repom.findById(mat_id).get();

        for(material_supplier objectms: repoms.findAll())
        {
            if(objectms.getMaterial().equals(objectm) &&  objectms.getSupplier().equals(objects))
            {
                objectm_s = objectms;
                break;
            }
        } 
        
        if(objectm_s != null)
        {
            int units = objectm_s.getUnits();
            if(unit_purchased<=units)
            {
                objectm_s.setUnits(units-unit_purchased);
                repoms.save(objectm_s);
                repoi.save(object);
                status[0]="Yes";
            }
        }
        // model.addAttribute("invoice_id", invoiceo.getInvoice_id());
        model.addAttribute("cust_id", invoiceo.getCust_id());
        model.addAttribute("units_purchased", invoiceo.getUnit_purchased());
        model.addAttribute("supp_id", invoiceo.getSupp_id());
        model.addAttribute("mat_id", invoiceo.getMat_id());
        return status[0].equals("Yes")? new ResponseEntity<>("Entry Updated",HttpStatus.OK):new ResponseEntity<>("Less number of units are available in the database for the selected mat_id and supp_id", HttpStatus.NOT_FOUND); 
    }

    @PostMapping("/details_material")
    @ResponseBody
    public String viewdetails_material(material material)
    { 
        repom.save(material);
        return repom.findAll().toString();
    }

    @PostMapping("/details_material_supplier")
    @ResponseBody
    public void viewdetails_material_supplier(material_supplier material_supplier , @RequestParam Integer mat_id )
    { 
        supplier objects = new supplier();
        material objectm = new material();

        User user = new User();
        user = userrepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Long iid = user.getUser_id();
        Integer supp_id = Math.toIntExact(iid);
        System.out.println(mat_id);
        System.out.println(material_supplier);
        System.out.println(supp_id);
        objects.setSupp_id(supp_id);
        objectm.setMat_id(mat_id);
        System.out.println(objects);
        System.out.println(objectm);
        // objects = repos.findById(sid).get();
        // objectm = repom.findById(mid).get();
        
        // Set<supplier> suppliers = new HashSet<>();

        // suppliers.add(objects);
        // objectm.setSuppliers(suppliers);

        // Set<material> materials = new HashSet<>();

        // materials.add(objectm);
        // objects.setMaterials(materials);

        material_supplier.setSupplier(objects);
        material_supplier.setMaterial(objectm);
        // objects.setSupp_id(supp_id);
        // objectm.setMat_id(mat_id);
        System.out.println(material_supplier);
        repoms.save(material_supplier);
        // repos.save(objects);
        // repom.save(objectm);
    }

    // public void msconnec()
    // {
    //     int mid = material_supplier.getMat_id();
    //     int sid = material_supplier.getSupp_id();

    //     supplier objects = new supplier();
    //     material objectm = new material();

    //     objects = repos.findById(sid).get();
    //     objectm = repom.findById(mid).get();
        
    //     Set<supplier> suppliers = new HashSet<>();

    //     suppliers.add(objects);
    //     objectm.setSuppliers(suppliers);

    //     Set<material> materials = new HashSet<>();

    //     materials.add(objectm);
    //     objects.setMaterials(materials);

    //     repos.save(objects);
    //     repom.save(objectm);
    // }
    // @RequestMapping("/get_details_material_supplier")
    // public String getdetails_material_supplier()
    // {
    //     return "viewmaterialsupplier";
    // }

    @PostMapping("/details_supplier")
    @ResponseBody
    public String viewdetails_supplier(supplier supplier)
    { 
        System.out.println(supplier);
        User user = new User();
        user = userrepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Long iid = user.getUser_id();
        Integer supp_id = Math.toIntExact(iid);
        supplier.setSupp_id(supp_id); 
        System.out.println(supp_id);
        System.out.println(supplier);
        repos.save(supplier);
        return repos.findAll().toString();
    }
}


   
    