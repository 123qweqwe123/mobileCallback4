## 整体说明
    短信回复信息、短信发送结果接收接口。
    供应商将回复短信、已经已发送短信的发送结果通过该服务传入我们的系统
    
## 使用方式

   做为独立的服务进行部署,由运营商调用
        
## 部署
    
    以jar包形式打包部署
    mvn clean install 
    将jar包上传到服务器
    nohup java -jar mobileCallback.jar &
    
## 注意事项
    该服务需要暴漏在外网,这样短信运营商才可以直接访问传递短信信息

## 版本说明
    