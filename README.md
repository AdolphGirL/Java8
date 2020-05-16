#### lambda

```
    /**
     * Lambda
	 * - 一種匿名函數，一段可以傳遞的方法；引入 -> 操作符
	 * - 左側
	 * 		Lambda表達式的參數列表
	 * 		可以看成當要實現一個interface方法時，需要傳入的參數
	 * - 右側
	 * 		Lambda表達式中所需要執行功能，即Lambda體
	 * 		可以看成當要實現一個interface方法時，需要實現的主體
	 * 
	 * - interfacefunction，Lambda需要一個函數式接口
	 * 		一個interface中，只有一個抽象方法的接口，即為interfacefunction
	 * 		使用@FunctionInterface宣告，作用，檢查此interface是否符合函數式接口
	 * 
	 * - 語法格式
	 * 		- 無參數、無法回值
	 * 			() -> System.out.println("")
	 * 		- 有一個參數、無法回值
	 * 			(x) -> System.out.println("")
	 * 		- 只有一個參數時，參數的小括號，可以省略
	 * 		- 如果有多條與句，則Lambda需要寫大括號
	 * 		- 如果只有一條與句，return和大括號都可以省略
	 * 		- 參數列表的數據類型可以省略不寫，因為jvm編譯器可以通過上下文推斷出數據的類型，稱之為類型推斷
	 * 
	 * 左右欲一括號省(return省)
	 * 左側推斷類型省
	 * 
	 */
```

#### 內建4大核心接口
- Consumer<T>，消費型接口，參數T、無返回值; void accept(T t);
  ```
	public class ConsumerTutorial {
		
		public static void main(String[] args) {
			new ConsumerTutorial().test();
		}
		
		public void test() {
			happy(1000.0, (m)->System.out.println("總共花了多少錢: " + m));
		}
		
		public void happy(Double money, Consumer<Double> con) {
			con.accept(money);
		}

	}
  ```
- Supplier<T>，供給型接口，參數T、有返回值；T get();  
  ```
	public class SupplierTutorial {
		
		/**
		* 隨機產生一指定個數(小於100)陣列
		*/
		public static void main(String[] args) {
			List<Integer> nums = new SupplierTutorial().genList(10, () -> (int)(Math.random()*100));
			nums.forEach(System.out::println);
		}
		
		/**
		* 供給型接口
		* Supplier -> T get();
		*/
		public List<Integer> genList(int num, Supplier<Integer> sup){
			List<Integer> numList = new ArrayList<>();
			
			for(int i=0; i<num; i++) {
				numList.add(sup.get());
			}
			
			return numList;
		}
		
	}
  ```  
- 