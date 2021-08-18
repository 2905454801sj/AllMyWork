import Home from "./views/Home";
import Aproducts from "./views/products";
import Bproducts from "./views/1products";
import Cproducts from "./views/2products";

export const routes=[
  {
    path: '/Home',
    component:Home
  },
  {
    path: '/Aproducts/:id',
    component: Aproducts
  },
  {
    path: '/Bproducts/:id',
    component: Bproducts
  },
  {
    path: '/Cproducts/:id',
    component: Cproducts
  }
]
