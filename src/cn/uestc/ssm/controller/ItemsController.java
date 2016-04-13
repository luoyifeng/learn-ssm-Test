package cn.uestc.ssm.controller;

import java.util.List;

import cn.uestc.ssm.exception.CustomException;
import cn.uestc.ssm.po.ItemsQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.uestc.ssm.po.ItemsCustom;
import cn.uestc.ssm.service.ItemsService;

import javax.servlet.http.HttpServletRequest;


@Controller
//为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：商品列表：/items/queryItems.action
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	// 商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,
								   ItemsQueryVo itemsQueryVo) throws Exception {

		// 测试forward后request是否可以共享

		//调用service查询数据库
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

	//商品修改页面的显示
	@RequestMapping(value = "/editItems",method = {RequestMethod.GET,RequestMethod.POST})
	public String editItems (Model model, @RequestParam(value = "id", required = true) Integer items_id) throws Exception {

		//调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);

		//判断商品是否为空，根据id没有查询到商品，抛出异常，提示用户商品信息不存在
		if (itemsCustom == null) {
			throw new CustomException("修改的商品信息不存在");
		}

		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
		model.addAttribute("itemsCustom", itemsCustom);
		return "items/editItems";
	}

	// 商品信息修改提交
	// 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
	// bindingResult接收校验出错信息
	// 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit (Model model,
								   HttpServletRequest request,
								   Integer id,
								   @Validated ItemsCustom itemsCustom,BindingResult bindingResult) throws Exception {
		//获取校验错误信息
		if (bindingResult.hasErrors()){
			//输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			for (ObjectError objectError : allErrors){
				//输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			//将错误信息传导页面
			model.addAttribute("allErrors", allErrors);
			return "items/editItems";
		}

		//调用service更新商品信息，页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
//		return "success";
		return "redirect:queryItems.action";
	}

	//商品批量删除
	@RequestMapping("/deleteItems")
	public String deleteItems (Integer[] items_id) throws Exception {
		//调用service更新商品信息，页面需要将商品信息传到此方法
		itemsService.deleteItems(items_id);
		return "redirect:queryItems.action";
	}
}

