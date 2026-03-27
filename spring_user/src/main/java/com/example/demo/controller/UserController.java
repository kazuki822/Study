package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 一覧画面
	 */
	@RequestMapping("/user/list")
	public String userList(Model model) {
		List<UserEntity> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";
	}

	/**
	 * 詳細画面
	 */
	@GetMapping("/user/{id}")
	public String userDetail(@PathVariable Integer id, Model model) {
		UserEntity user = userService.findById(id);
		model.addAttribute("userData", user);
		return "user/view";
	}

	/**
	 * 新規登録画面
	 */
	@RequestMapping("/user/add")
	public String userRegister(Model model) {

		Map<Integer, String> genderMap = setGenderMap();

		// ★これが超重要（今回のエラー原因）
		model.addAttribute("userRequest", new UserRequest());
		model.addAttribute("genderMap", genderMap);

		return "user/add";
	}

	/**
	 * 新規登録処理
	 */
	@RequestMapping("/user/create")
	public String userCreate(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {

		Map<Integer, String> genderMap = setGenderMap();

		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			model.addAttribute("genderMap", genderMap);
			return "user/add";
		}

		try {
			userService.create(userRequest);
		} catch (IllegalArgumentException e) {
			model.addAttribute("businessError", e.getMessage());
			model.addAttribute("genderMap", genderMap);
			return "user/add";
		}

		return "redirect:/user/list";
	}

	/**
	 * 性別Map取得
	 */
	private Map<Integer, String> setGenderMap() {
		return userService.getGenderMap();
	}

	/**
	 * ユーザー情報削除
	 * 
	 * @param id    表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/user/{id}/delete")
	public String userDelete(@PathVariable Integer id, Model model) {
		// ユーザー情報の削除
		userService.delete(id);
		return "redirect:/user/list";
	}
}
