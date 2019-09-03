# 代理模式
## 1、应用场景
在生活中，我们经常见到这样的场景，如：租房中介、售票黄牛、婚介、经纪人、快递、事务代理、非侵入式日志监听等，这些都是代理模式的实际体现。代理模式（ProxyPattern）的定义也非常简单，是指为其他对象提供一种代理，以控制对这个对象的访问。代理对象在客服端和目标对象之间起到中介作用，代理模式属于结构型设计模式。使用代理模式主要有两个目的：一保护目标对象，二是对对象的某一功能的流程把控和辅助。在代码中，我们想到代理，就会理解为是代码增强，其实就是在原本逻辑前后增加一些逻辑，而调用者无感知。代理模式属于结构型模式，有静态代理和动态代理两种实现方式。

## 2、静态代理
### 2.1、生活场景举例
举个例子：随着互联网和OTO模式的发展，人们越来越喜欢在家点餐就会有骑手小哥送餐的外卖形式，在这个过程中餐厅只能完成制作美食，而骑手小哥就是对餐厅卖餐的代理，实现了送餐流程的辅助效果。
我们创建Restaurant.java餐厅接口
```
//餐厅接口
public interface Restaurant {

	//送餐方法
	public void foodDelivery();
}
```
个人点外卖还是喜欢田老师红烧肉，故创建TianRestaurant.java 田老师餐厅类实现顶层接口
```
public class TianRestaurant implements Restaurant{

	@Override
	public void foodDelivery() {
		System.out.println("制作美食");
	}
}
```
为了达到送餐的目的，我们还需要对餐厅的送餐行为进行代理，故创建RestaurantProxy代理类,在餐厅的送餐方法前后，加入了代理的功能实现。
```
public class RestaurantProxy implements Restaurant{

	private Restaurant restaurant;

	public RestaurantProxy(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public void foodDelivery() {
		System.out.println("骑手接单");
		restaurant.foodDelivery();
		System.out.println("骑手取餐,送往用户");
	}
}
```

创建用户调用类
```
public class User {

	public static void main(String[] args) {
		RestaurantProxy restaurantProxy = new RestaurantProxy(new TianRestaurant());
		System.out.println("用户下单");
		restaurantProxy.foodDelivery();
		System.out.println("用户接餐");
	}
}
```
console打印结果:
```
用户下单
骑手接单
制作美食
骑手取餐,送往用户
用户接餐
```

### 2.2、实际功能场景举例
上述例子为生活中场景的代理模式的实现，再来例举下在代码功能层次的实现。
在分布式业务场景中，我们通常会按照某种分配规则对数据库进行分库分表，分库分表之后使用 Java 操作时，就可能需要配置多个数据源，我们通过设置数据源路由来动态切换数据源。我们通过实际场景中的三层结构来模拟实现动态切换数据源的效果。



