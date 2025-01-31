<template>
  <div class="main-page">
    <CommonBannerVue />
    <div class="main">
      <CategoryList v-model:selectedCategory="selectedCategory" />
      <div class="search-bar">
        <input type="text" id="search" @keyup.enter="onClickSearch" />
        <label @click="onClickSearch">
          <span class="material-icons-outlined"> search </span>
        </label>
      </div>
      <div v-if="products.length" class="card-list">
        <ProductCardVue :products="products" @click="onClickProductCard" />
      </div>
      <EmptyProduct v-else />
    </div>
    <div class="add-button">
      <button @click="onClickAddProduct">
        <span class="material-icons-outlined"> add </span>
      </button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref, watchEffect } from 'vue';
import router from '@/router';
import ProductCardVue from '@/components/ProductCard.vue';
import CommonBannerVue from '@/components/CommonBanner.vue';
import CategoryList from '@/components/CategoryList.vue';
import productAPI from '@/apis/user/product';
import type { IProduct } from '@/types/product';
import EmptyProduct from '@/components/EmptyProduct.vue';

const selectedCategory = ref('ALL');

const products = ref<Array<IProduct>>([]);

const onClickSearch = () => {
  // TODO: 상품 검색
};

const onClickAddProduct = () => {
  router.push('/product/add');
};

const onClickProductCard = (id: number) => {
  router.push(`product/${id}`);
};

watchEffect(() => {
  // TODO: 카테고리별 상품
});

onMounted(async () => {
  const res = await productAPI.getAll();
  if (res.isSuccess && res.data) {
    products.value = res.data;
  } else {
    console.error(res.message);
  }
});
</script>

<style scoped>
.main-page {
  width: 100%;
  height: 100%;
}
.main {
  width: 100%;
  height: 100%;
  margin-top: 24px;
}

.search-bar {
  position: relative;
  width: 100%;
  margin-top: 12px;

  display: flex;
  justify-content: center;
  align-items: center;
}
.search-bar > input {
  width: 80%;
  padding: 12px;
  font-size: 18px;
  padding-right: 36px;
}
.search-bar > label {
  position: absolute;
  right: calc(10% + 12px);
  top: 12px;
  cursor: pointer;
}
.card-list {
  width: 80%;

  margin: auto;
  margin-top: 24px;
  padding: 24px;

  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  justify-items: center;
  gap: 24px;
}
.add-button {
  position: sticky;
  bottom: 24px;
  right: 0;
  text-align: end;
}
.add-button > button {
  border: 1px solid #48583f;
  background-color: var(--product-add-btn-bg);
  color: var(--product-add-btn-text);
  border-radius: 50%;
  width: 64px;
  height: 64px;
}

@media screen and (max-width: 1200px) {
  .card-list {
    grid-template-columns: 1fr 1fr;
  }
}

@media screen and (max-width: 1023px) {
  .card-list {
    grid-template-columns: 1fr 1fr;
  }
  .category {
    display: none;
  }
  .small-category {
    display: flex;
    flex-direction: column;
    align-items: end;
    width: 100%;
  }
  .small-category > ul {
    width: fit-content;
    flex-wrap: wrap;
  }
  .small-category > div {
    width: 100%;
    background-color: rgb(232, 249, 255);
    border: 1px solid rgba(135, 135, 135, 0.32);
    border-radius: 12px;
    padding: 12px 24px;
    text-align: center;
    font-size: 18px;
    font-weight: 700;
    justify-content: right;
  }
  .add-button {
    padding-right: 24px;
  }
}

@media screen and (max-width: 767px) {
  .card-list {
    grid-template-columns: 1fr;
  }
}
</style>
