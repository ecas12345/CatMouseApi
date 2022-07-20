package com.eric.catMouseApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.catMouseApi.models.ScenarioRequest;
import com.eric.catMouseApi.service.CatMouseService;

@RestController
@RequestMapping("/submitScenario")
public class CatMouse {
		
		@Autowired
		CatMouseService cmService;

		@CrossOrigin
		@PostMapping
		public String postScenario(@RequestBody ScenarioRequest request) {
			return this.cmService.isCaught(request.getScenario(), request.getSpacesCanJump());
		}
}
