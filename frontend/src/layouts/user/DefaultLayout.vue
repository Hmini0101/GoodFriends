<template>
  <div id="wrap">
    <DefaultHeader />
    <RouterView id="main" />
    <LoadingIcon v-if="store.isLoading" />
    <DefaultFooter />
  </div>
</template>

<script setup lang="ts">
import { RouterView } from 'vue-router';
import DefaultHeader from '@/layouts/user/DefaultHeader.vue';
import DefaultFooter from '@/layouts/user/DefaultFooter.vue';
import LoadingIcon from '@/components/LoadingIcon.vue';
import { useLoadingStore } from '@/stores/loading';

const store = useLoadingStore();
</script>

<style scoped>
#wrap {
  min-height: 100%;
  position: relative;
  padding-bottom: 150px;
  font-family: 'LINESeedKR-Rg';
}

#main {
  width: 100%;
  padding: 10px 200px;
}

@media screen and (max-width: 1023px) {
  #main {
    padding: 10px 0;
  }
}

@media screen and (max-width: 767px) {
  #main {
    padding: 10px 0;
  }
}
</style>
