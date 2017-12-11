# humanresourcemanager
springmvc+hibernate+mysql+activemq+redis项目集成例子

项目规约：
一、基础类规约：
  1、变量命名方式为驼峰命名方式。
  2、变量名统一为英文单词或英文组合词。（请勿提交意义不明或包含歧义、二义性、歧视性的变量名）
  3、单个方法长度为一屏：最多60行。如果有超出的，请自行抽取出子方法。
  4、工程内部各个类请添加/** */类注释。
  5、类内部方法需要提供/** */类注释，特别是工具类静态方法。
  6、多次调用的相同多行代码需要抽取封装为工具方法。
  7、项目中有Ajax请求数据，故而请在新建实体类中创建toJson，以及toJsonArray方法，对应生成单个实体JsonObject以及list类型的JsongArray数据。
  8、项目中需要提供给外部程序使用的方法服务，请主动提交Junit测试类至git，并保证Junit测试成功。【非外部程序使用方法也欢迎提交Junit测试类】
二、类规约
  1、单个Controller只实现一个功能：
      如getAccountListController中，只包含getAccountINfoList方法
      说明：此规约为实现添加Interceptor对查询类Controller，添加Cache服务相关内容，如加锁，加BloomFilter验证
  3、类命名统一为：
      接口类：XXX+"Service" or XXX+"Dao"
      实现：XXX+"ServiceImpl" or XXX+"DaoImol"
      
      工具类：XXX+"Util"
