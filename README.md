Guava Cache
===

1. Guava Cache 提供了一套方法來管理快取，並可使用 CacheBuilder 類設置各種參數，例如過期策略和最大容量等。
2. 通過 put 和 get 方法可以方便新增或取得快取資料。
3. 在微服務環境下使用 Guava Cache 時，每個服務都會維護自己的快取資料
4. 此專案演示 Guava Cache 如何用來判斷 token 是否失效