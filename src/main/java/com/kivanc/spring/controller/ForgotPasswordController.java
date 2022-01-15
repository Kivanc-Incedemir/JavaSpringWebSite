package com.kivanc.spring.controller;

import com.kivanc.spring.entity.User;
import com.kivanc.spring.service.UserService;
import com.kivanc.spring.utility.Utility;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return "forgot_password";

    }

    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model theModel) {
        String email = request.getParameter("email");
        String token = RandomString.make(30);

        try {
        userService.updateResetPasswordToken(token,email);
        String resetPasswordLink = Utility.getSiteURl(request) + "/reset_password?token=" + token;
        sendEmail(email,resetPasswordLink);
        theModel.addAttribute("message","We have sent a reset password link to your email. Please check.");
        } catch (UsernameNotFoundException ex){
            theModel.addAttribute("error",ex.getMessage());
        } catch (UnsupportedEncodingException | MessagingException e) {
            theModel.addAttribute("error","Error while sending email");
        }
    return "forgot_password";
    }

    public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("contact@shopme.com","Shopme Support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                +  "<p> Ignore this email if you do remember your password,"
                +"or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content,true);

        mailSender.send(message);

    }


    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        User user = userService.getByResetPasswordToken(token);
        model.addAttribute("token",token);

        if(user == null){
            model.addAttribute("message","Invalid Token");
            return "message";
        }
        return "reset_password";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model ) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User theUser = userService.getByResetPasswordToken(token);
        model.addAttribute("title","Reset your password");

        if(theUser == null){
            model.addAttribute("message","Invalid Token");
            return "message";
        } else{
            userService.updatePassword(theUser,password);
            model.addAttribute("message","You have successfully changed your password.");
        }
        return "message";
    }

}
