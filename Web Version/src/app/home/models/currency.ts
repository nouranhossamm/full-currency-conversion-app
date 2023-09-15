export interface ICurrency {
  name: string;
  code: string;
  icon_url: string;
  checked?: boolean;
  value?: number;
}

export interface ICurrencyResponse{
  data: ICurrency[];
  message: string;
}

export interface ICodesResponse {
data:{
   conversion_rates: {
    [code: string]: number;
  };
}
}
