package com.outer_shopping.project.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.outer_shopping.project.service.OuterPictureService;
import com.outer_shopping.project.service.OuterService;
import com.outer_shopping.project.service.OuterSizeService;
import com.outer_shopping.project.vo.OuterPictureVo;
import com.outer_shopping.project.vo.OuterSizeVo;
import com.outer_shopping.project.vo.OuterVo;

@Controller
@RequestMapping("/admin")
public class AdminOuterController {

	private static final Logger logger = LoggerFactory.getLogger(AdminOuterController.class);
	
	@Autowired
	private OuterService outerService;
	
	@Autowired
	private OuterSizeService sizeService;
	
	@Autowired
	private OuterPictureService pictureService;
	
	@Autowired
	private FileSystemResource uploadDirResource;
	
	@RequestMapping(value = "/outerForm", method=RequestMethod.GET)
	public String outerForm(Model model) {
		
		if(!model.containsAttribute("outerPictureVo")) 
			model.addAttribute("outerPictureVo", new OuterPictureVo());
		
		return "admin/addOuterForm";
	}
	
/*    @RequestMapping(value = "/addOuterProduct", method = RequestMethod.POST)
    public String addOuterProduct(Model model,@ModelAttribute("outerVo") OuterVo outerVo, BindingResult result){
	   
    	
		MultipartFile file = outerVo.getImageFile(); // 업로드 파일

		FileOutputStream fos = null;

		// 업로드 파일 처리
		if (!outerVo.getImageFile().isEmpty() && file != null) {
			
			String fileName = file.getOriginalFilename();
			                            
            try{
                  byte[] bytes = file.getBytes();
        
                  File outFileName = new File(uploadDirResource.getPath() + fileName);
                  
                  outerVo.setImageName(fileName);
                  outerVo.setThumbnailUrl(uploadDirResource.getPath() + fileName);
                  
                  fos = new FileOutputStream(outFileName);
                  
                  fos.write(bytes);
            }catch(IOException e) {
            	
            	logger.info("############# 이미지 등록 에러 #############");
                e.printStackTrace();
                
            }finally{
            	
                  try{    
                     if (fos !=null) fos.close();
                  }catch (IOException e) {
                     e.printStackTrace();
                  }
            }
            logger.info("############# 이미지 등록 #############");
		}

		service.createOuter(outerVo);
	  
	   return "admin/addSize";
    }*/
	/**
	 * 아웃터 등록
	 */
	@RequestMapping(value = "/addOuterProduct", method = RequestMethod.POST)
	@ResponseBody
    public String addOuterProduct(Model model, MultipartHttpServletRequest multi){
	   
		OuterVo outer = new OuterVo();
		
		String path = uploadDirResource.getPath();
		
		String newFileName = ""; // 업로드 되는 파일명
        
        File dir = new File(path);
        if(!dir.isDirectory()){
            dir.mkdir();
        }
         
        Iterator<String> files = multi.getFileNames();
        
        while(files.hasNext()){
            String uploadFile = files.next();
                         
            MultipartFile mFile = multi.getFile(uploadFile);
            String fileName = mFile.getOriginalFilename();
            
            System.out.println("실제 파일 이름 : " +fileName);
            
            newFileName = System.currentTimeMillis()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
            outer.setImageName(newFileName);
             
            try {
            	outer.setThumbnailUrl(path+newFileName);
                mFile.transferTo(new File(path+newFileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
        logger.info("############# 이미지 등록 #############");
       
       	outer.setName(multi.getParameter("name"));
		outer.setContent(multi.getParameter("content"));
		outer.setType(multi.getParameter("type"));
		outer.setPrice(Integer.parseInt(multi.getParameter("price")));
      
		outerService.createOuter(outer);
		
		System.out.println(outer.getOuterNo());
		model.addAttribute("outerNo", outer.getOuterNo());
		
		logger.info("############# 상품 등록 #############");
		
		return Integer.toString(outer.getOuterNo());
	}
	
	/**
	 * 아웃터 사이즈 등록
	 */
	@RequestMapping(value = "/addOuterSize", method = RequestMethod.POST)
	@ResponseBody
    public String addOuterSize(@RequestParam(value="sizeList[]",required=false) List<String> sizeList,
    		@RequestParam(value="outerNo",required=false) int outerNo){
		System.out.println(sizeList);
		for (int i = 0; i < sizeList.size(); i++) {
			OuterSizeVo outerSize = new OuterSizeVo();
			
			outerSize.setType(sizeList.get(i).toString());							i++;
			outerSize.setChest(Integer.parseInt(sizeList.get(i).toString()));		i++;
			outerSize.setSleeve(Integer.parseInt(sizeList.get(i).toString()));		i++;
			outerSize.setShoulder(Integer.parseInt(sizeList.get(i).toString()));	i++;
			outerSize.setWhole(Integer.parseInt(sizeList.get(i).toString()));		i++;
			outerSize.setAmount(Integer.parseInt(sizeList.get(i).toString()));		i++;
			outerSize.setColor(sizeList.get(i).toString());
			outerSize.setOuterNo(outerNo);
			
			sizeService.createOuterSize(outerSize);
		}
		
		logger.info("############# 아웃터 사이즈 등록 #############");
		
		return "등록";
	}

	/**
	 * 아웃터 이미지 등록
	 */
	@RequestMapping(value = "/addOuterPicture", method = RequestMethod.POST)
    public String addOuterPicture(@ModelAttribute("outerPictureVo") OuterPictureVo outerPictureVo,
    		RedirectAttributes ra){
			
		List<MultipartFile> file = outerPictureVo.getImageFiles(); // 업로드 파일
			
		for (int i = 0; i < file.size(); i++) {
			
			OuterPictureVo picture = new OuterPictureVo();
			
			FileOutputStream fos = null;
			
			// 업로드 파일 처리
			if (!outerPictureVo.getImageFiles().isEmpty() && file != null) {
				
				String fileName = file.get(i).getOriginalFilename();
				                            
	            try{
	                  byte[] bytes = file.get(i).getBytes();
	        
	                  File outFileName = new File(uploadDirResource.getPath() + fileName);
	                  
	                  picture.setPrictureName(fileName);
	                  
	                  picture.setPrictureUrl(uploadDirResource.getPath() + fileName);
	                  
	                  fos = new FileOutputStream(outFileName);
	                  
	                  fos.write(bytes);
	                  
	                  picture.setOuterNo(outerPictureVo.getOuterNo());
	                  
	                  pictureService.createOuterPicture(picture);
	            }catch(IOException e) {
	            	
	            	logger.info("############# 이미지 등록 에러 #############");
	                e.printStackTrace();
	                
	            }finally{
	            	
	                  try{    
	                     if (fos !=null) fos.close();
	                  }catch (IOException e) {
	                     e.printStackTrace();
	                  }
	            }
	            logger.info("############# 이미지 등록 #############");
			}
		}
		
		ra.addAttribute("outerNo",outerPictureVo.getOuterNo());
		
		logger.info("############# 장바구니 존재 #############");
		
		return "redirect:/outer/outerView.do";
	}
	
	/**
	 * 아웃터 상품 정보 수정 페이지 이동
	 */
	@RequestMapping(value = "/modifyOuterPage", method = RequestMethod.POST)
    public String modifyOuterProduct(Model model, @RequestParam(value="outerNo",required=false) int outerNo,
    		 @RequestParam(value="modify",required=false) String modify){
		
		OuterVo outer = new OuterVo();
		
		outer = outerService.getOuter(outerNo);
	
		model.addAttribute("outerVo", outer);
		
		if(modify.equals("사이즈")) {
			logger.info("############# 아웃터 사이즈 수정 페이지 이동 #############");
			
			return "admin/modifyOuterSizeForm";
		}
		
		if(modify.equals("이미지")) {
			return "admin/modifyOuterImageForm";
		}
		
		logger.info("############# 아웃터 수정 페이지 이동 #############");
		
		return "admin/modifyOuterProductForm";
	}
	
}
