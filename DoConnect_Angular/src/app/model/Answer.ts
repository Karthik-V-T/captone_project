import { Question } from "./Question";
import { Topic } from "./Topic";
import { User } from "./User";

export interface Answer {
    id?: number;
    answername: string;
    answerimage?: string;
    user: User;
    question: Question;
    astatus: number
}

