package com.outer_shopping.project.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import net.coobird.thumbnailator.Thumbnails;

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
	
	/**
	 * 뷰페이지 이동
	 */
	public String outerViewPage(RedirectAttributes ra, int outerNo) {
		ra.addAttribute("outerNo", outerNo);
		
		logger.info("############# 상품 상세페이지 이동 #############");
		
		return "redirect:/outer/outerView.do";
	}
	
	
	
	@RequestMapping(value = "/outerForm", method=RequestMethod.GET)
	public String outerForm(Model model) {
		
		if(!model.containsAttribute("outerPictureVo")) 
			model.addAttribute("outerPictureVo", new OuterPictureVo());
		
		return "admin/addOuterForm";
	}
	
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
	        	
	        FileOutputStream fos = null;
	        
	        while(files.hasNext()){
	            String uploadFile = files.next();
	                         
	            MultipartFile mFile = multi.getFile(uploadFile);
	            String fileName = mFile.getOriginalFilename();
	            
	            System.out.println("실제 파일 이름 : " +fileName);
	            
	          
	            newFileName = System.currentTimeMillis()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
	            outer.setImageName(newFileName);
	            
	            try {	            	
	                mFile.transferTo(new File(path+newFileName)); 
	                
	                // 썸네일(thumbnail) path : PNG 형식으로 저장	               
		            File outFileName = new File(uploadDirResource.getPath() + newFileName);
		            
		            String thumbPath = uploadDirResource.getPath() + "thumbnail/";
		            String thumbPathFileName = "thumb_"
		           		 				  + newFileName.split("\\.")[0]
		   		 						  +".png";
		            outer.setThumbnailName(thumbPathFileName);
		            
		            // 썸네일 200*100 크기의 썸네일 작성
		            File thumbnail = new File(thumbPathFileName); 

		            Thumbnails.of(outFileName)
		         	 		   .size(200, 100)
		 	 				   .outputFormat("png")
		         	 		   .toFile(thumbPath + thumbnail); 
		            
		            
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

		System.out.println(outerPictureVo);
		
		List<MultipartFile> file = outerPictureVo.getImageFiles(); // 업로드 파일
		
		try {
			if(!outerPictureVo.getImageFiles().isEmpty() && file.size() > 0 && file != null) {	

				for (int i = 0; i < file.size(); i++) {
					
					OuterPictureVo picture = new OuterPictureVo();
					
					FileOutputStream fos = null;
					
					// 업로드 파일 처리
					if (!outerPictureVo.getImageFiles().isEmpty() && file != null) {
						
						//String fileName = file.get(i).getOriginalFilename();
						String fileName = System.currentTimeMillis()+"."+file.get(i).getOriginalFilename().substring(file.get(i).getOriginalFilename().lastIndexOf(".")+1);                          
			            try{
			                  byte[] bytes = file.get(i).getBytes();
			        
			                  File outFileName = new File(uploadDirResource.getPath() + fileName);
			                  
			                  picture.setPictureName(fileName);
			                  
			                  picture.setPictureUrl(uploadDirResource.getPath() + fileName);
			                  
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
			}
		} catch (Exception e) {
			logger.info("############# 새로운 이미지 등록 X #############");
			
			ra.addAttribute("outerNo",outerPictureVo.getOuterNo());
			
			logger.info("############# 상품 상세페이지 이동 #############");
			
			return "redirect:/outer/outerView.do";
		}
		
		return outerViewPage(ra,outerPictureVo.getOuterNo());
		
	}
	
	/**
	 * 아웃터 상품 정보 수정 페이지 이동
	 */
	@RequestMapping(value = "/modifyOuterPage.do", method = RequestMethod.POST)
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
			if(!model.containsAttribute("outerPictureVo")) 
				model.addAttribute("outerPictureVo", new OuterPictureVo());
			
			logger.info("############# 아웃터 이미지 수정 페이지 이동 #############");
			
			return "admin/modifyOuterImageForm";
		}
		
		logger.info("############# 아웃터 수정 페이지 이동 #############");
		
		return "admin/modifyOuterProductForm";
	}
	
	/**
	 * 아웃터 수정
	 */
	@RequestMapping(value = "/modifyOuterProduct", method = RequestMethod.POST)
    public String modifyOuterProduct(Model model,@ModelAttribute("outerVo") OuterVo outerVo,RedirectAttributes ra){
	   		
		System.out.println(outerVo);
		
		if(outerVo.getImageName() != null) {
	        outerService.modifyOuter(outerVo);

	        ra.addAttribute("outerNo",outerVo.getOuterNo());
			logger.info("############# 상품수정 등록 #############");
			
			return "redirect:/outer/outerView.do";
		}

		MultipartFile file = outerVo.getImageFile(); // 업로드 파일
		
		
		FileOutputStream fos = null;
		
		// 업로드 파일 처리
		if (!outerVo.getImageFile().isEmpty() && file != null) {
			
			String fileName = file.getOriginalFilename();
			 
			String newFileName ="";
            try{
            	byte[] bytes = file.getBytes();
            	
            	newFileName = System.currentTimeMillis()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
    
            	File outFileName =  new File(uploadDirResource.getPath() + newFileName);
              
              	outerVo.setImageName(newFileName);
                
              	fos = new FileOutputStream(outFileName);
              
              	fos.write(bytes);
                  
              	// 썸네일(thumbnail) path : PNG 형식으로 저장	               
	          
	            String thumbPath = uploadDirResource.getPath() + "thumbnail/";
	            String thumbPathFileName = "thumb_"
	           		 				  + newFileName.split("\\.")[0]
	   		 						  +".png";
	            outerVo.setThumbnailName(thumbPathFileName);
	            
	            // 썸네일 200*100 크기의 썸네일 작성
	            File thumbnail = new File(thumbPathFileName); 

	            Thumbnails.of(outFileName)
	         	 		   .size(200, 100)
	 	 				   .outputFormat("png")
	         	 		   .toFile(thumbPath + thumbnail);
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

        outerService.modifyOuter(outerVo);
        
        return outerViewPage(ra,outerVo.getOuterNo());
	}
	
	/**
	 * 아웃터 사이즈 수정
	 */
	@RequestMapping(value = "/ModefiyOuterSize", method = RequestMethod.POST)
    public String ModefiyOuterSize(@RequestParam Map<String, Object> map, RedirectAttributes ra){
		
		//등록하는 사이즈 정보 갯수
		int tt = Integer.parseInt(map.get("index").toString()) + 1;
		
		//기존에 사이즈 정보 삭제
		sizeService.removeOuterSize(Integer.parseInt(map.get("outerNo").toString()));

		//사이즈 등록
		for (int i = 1; i < tt; i++) {
			OuterSizeVo outerSize = new OuterSizeVo();
			
			outerSize.setType(map.get("productSize_type"+i).toString());		
			outerSize.setChest(Integer.parseInt(map.get("productSize_chest"+i).toString()));		
			outerSize.setSleeve(Integer.parseInt(map.get("productSize_sleeve"+i).toString()));		
			outerSize.setShoulder(Integer.parseInt(map.get("productSize_shoulder"+i).toString()));	
			outerSize.setWhole(Integer.parseInt(map.get("productSize_whole"+i).toString()));		
			outerSize.setAmount(Integer.parseInt(map.get("productSize_amount"+i).toString()));		
			outerSize.setColor(map.get("productSize_color"+i).toString());
			outerSize.setOuterNo(Integer.parseInt(map.get("outerNo").toString()));
			
			sizeService.createOuterSize(outerSize);
		}
		logger.info("############# 상품수정 등록 #############");
		
		return outerViewPage(ra,Integer.parseInt(map.get("outerNo").toString()));
	}
	
	/**
	 * 아웃터 이미지 삭제
	 */
	@RequestMapping(value = "/removeOuterPicture.do", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
    public String removeOuterPicture(@RequestParam(value="pictureNo",required=false) int pictureNo){
		
		pictureService.removeOuterPicture(pictureNo);
		
		logger.info("############# 상품 이미지 삭제 #############");
		
		return "삭제";
	}
}
